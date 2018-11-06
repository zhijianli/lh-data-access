package com.bozhong.lhdataaccess.security;

import com.bozhong.config.common.ConfigSetPropertyHolder;
import com.bozhong.lhdataaccess.common.util.LongHuaWebsiteLog;
import com.bozhong.myredis.MyRedis;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;
import com.yx.eweb.main.PipeLineInter;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全性验证
 *
 * @author bin
 * @create 2018-04-28 上午10:46
 **/

public class SecurityPipeLine implements PipeLineInter {
    private Logger logger = LongHuaWebsiteLog.SECURITY_LOG;
    private final static String SECURITY = ConfigSetPropertyHolder.getProperty("security");

    private MyRedis myRedis;

    public void setMyRedis(MyRedis myRedis) {
        this.myRedis = myRedis;
    }

    public boolean run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        EWebContext eWebContext = EWebServletContext.getEWebContext();

        EWebRequestDTO eweb =(EWebRequestDTO)eWebContext.getParam();

        String  url = eweb.getRequestUrl();

        logger.debug("EWebRequestDTO url "+url);

        /**
         * ajax在进行复杂请求如PUT,POST,DELETE等时，当请求为cross domain request是，会先发一个OPTIONS请求确认服务器的跨域支持情况，
         * 在发送原来的请求，所以对于服务器，需要对OPTIONS请求做一次
         */
        if (httpServletRequest.getMethod().equals("OPTIONS") ) {
            return true;
        }

        //dev环境不走认证
        if(!SECURITY.equals("true")){
            return true;
        }

        logger.warn("SecurityPipeLine has excute !! ");
//
//        Cookie tokenCookie = CookiesUtil.getCookieByName(httpServletRequest, "token");
//        if (tokenCookie == null) {
//            //return false;
//            try {
//                httpServletResponse.sendRedirect(BizCenterConst.LOGIN_URL);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return false;
//        }
//
//        String token = tokenCookie.getValue();
////        因为redis公用,所以直接去redis中取运营后台的登录信息
//        String uId = myRedis.getForStr(BizCenterConst.BIZ_CENTER_USERNAME_PREFIX + token);
//        if (StringUtils.isNotBlank(uId)) {
//            EWebServletContext.getEWebContext().put("uId", uId);
//            return true;
//        }
//
//        try {
//            httpServletResponse.sendRedirect(BizCenterConst.LOGIN_URL);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return false;
    }

}