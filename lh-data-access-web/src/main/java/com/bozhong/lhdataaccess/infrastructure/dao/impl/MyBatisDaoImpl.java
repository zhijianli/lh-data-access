package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.infrastructure.dao.MyBatisDao;
import com.zhicall.core.mybatis.dao.DatabaseException;
import com.zhicall.core.mybatis.mapper.MapMapper;
import com.zhicall.core.mybatis.page.Page;
import com.zhicall.core.mybatis.page.PageRequest;
import com.zhicall.core.mybatis.plugin.SelectCountSqlInterceptor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bin
 * @create 2018-04-28 下午3:59
 **/

public class MyBatisDaoImpl extends SqlSessionDaoSupport implements MyBatisDao {


    private static final Logger logger = LoggerFactory.getLogger("sqlLog");

    public MyBatisDaoImpl() {}

    /**
     * 插入一个实体
     *
     * @param sqlMapId  mybatis 映射id
     * @param object  实体参数
     * @return
     */
    public int insert(final String sqlMapId, final Object object) {

        return (Integer) execute(new SqlSessionCallback() {

            public Object doInSession(SqlSession session) {
                try {
                    return session.insert(sqlMapId, object);
                } catch (Exception e) {
                    logger.error("SQL执行出错: " + sqlMapId, e);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, e);
                }
            }
        });
    }

    /**
     * 查询列表
     *
     * @param sqlMapId  mybatis映射id
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List findForList(String sqlMapId) {
        return findForList(sqlMapId, null);
    }

    /**
     * 查询列表
     *
     * @param sqlMapId  mybatis映射id
     * @param param  查询参数
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List findForList(final String sqlMapId, final Object param) {

        return (List) execute(new SqlSessionCallback() {

            public Object doInSession(SqlSession session) {
                try {
                    if (param != null) {
                        return session.selectList(sqlMapId, param);
                    } else {
                        return session.selectList(sqlMapId);
                    }
                } catch (Exception e) {
                    logger.error("SQL执行出错: " + sqlMapId, e);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, e);
                }
            }
        });
    }

    /**
     * 查询列表
     *
     * @param sqlMapId  mybatis映射id
     * @param param  查询参数
     * @param offset  查询起始位置(偏移量),从1开始
     * @param limit  查询数量,必须大于0
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List findForList(final String sqlMapId, final Object param, final int offset, final int limit) {

        return (List) execute(new SqlSessionCallback() {

            public Object doInSession(SqlSession session) {
                try {
                    return session.selectList(sqlMapId, param, new RowBounds(offset, limit));
                } catch (Exception e) {
                    logger.error("SQL执行出错: " + sqlMapId, e);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, e);
                }
            }
        });
    }

    /**
     * 获取结果集的map
     *
     * @param sqlMapId  mybatis映射id
     * @param mapMapper  处理多行结果集的接口,指定map的key和value
     * @return 结果对象的map
     */
    @SuppressWarnings("rawtypes")
    public Map findForMap(final String sqlMapId, final MapMapper mapMapper) {
        return findForMap(sqlMapId, null, mapMapper);
    }

    /**
     * 获取结果集的map
     *
     * @param sqlMapId  mybatis映射id
     * @param parameter  参数数组
     * @param mapMapper  处理多行结果集的接口,指定map的key和value
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map findForMap(final String sqlMapId, final Object parameter, final MapMapper mapMapper) {

        List list = null;
        if (parameter == null) {
            list = findForList(sqlMapId);
        } else {
            list = findForList(sqlMapId, parameter);
        }

        Map result = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            result.put(mapMapper.mapKey(list.get(i), i + 1), mapMapper.mapValue(list.get(i), i + 1));
        }
        return result;
    }

    /**
     * 带有分页信息的查询
     *
     * @param sqlMapId  mybatis映射id
     * @param pageRequest  分页请求参数信息
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Page findForPage(String sqlMapId, PageRequest pageRequest) {

        // 查询总数
        pageRequest.getFilters().put(SelectCountSqlInterceptor.COUNT, null); // 设置是否需要将sql转换成总数查询sql
        Number totalCount = (Number) findForObject(sqlMapId, pageRequest.getFilters());
        if (totalCount == null || totalCount.intValue() <= 0) {
            return new Page(pageRequest, 0);
        }
        if (totalCount != null && totalCount.intValue() <= (pageRequest.getPageNumber() - 1) * pageRequest.getPageSize()) {
            return new Page(pageRequest.getPageNumber(), pageRequest.getPageSize(), totalCount.intValue(), new ArrayList(0));
        }
        pageRequest.getFilters().remove(SelectCountSqlInterceptor.COUNT);

        Map filters = new HashMap();
        filters.putAll(pageRequest.getFilters());
        Page page = new Page(pageRequest, totalCount.intValue());
        List list = findForList(sqlMapId, filters, page.getFirstResult(), page.getPageSize());

        page.setResult(list);

        return page;
    }

    /**
     * 查询得到一个实体
     *
     * @param sqlMapId
     *            mybatis映射id
     * @return
     */
    public Object findForObject(final String sqlMapId) {

        return findForObject(sqlMapId, null);
    }

    /**
     * 查询得到一个实体
     *
     * @param sqlMapId  mybatis映射id
     * @param param  查询参数
     * @return
     */
    public Object findForObject(final String sqlMapId, final Object param) {

        return execute(new SqlSessionCallback() {

            public Object doInSession(SqlSession session) {
                try {
                    if (param != null) {
                        return session.selectOne(sqlMapId, param);
                    } else {
                        return session.selectOne(sqlMapId);
                    }
                } catch (Exception e) {
                    logger.error("SQL执行出错: " + sqlMapId, e);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, e);
                }
            }
        });
    }

    /**
     * 修改
     *
     * @param sqlMapId  mybatis映射id
     * @param param  参数
     * @return
     */
    public int update(final String sqlMapId, final Object param) {

        return (Integer) execute(new SqlSessionCallback() {

            public Object doInSession(SqlSession session) {
                try {
                    return session.update(sqlMapId, param);
                } catch (Exception e) {
                    logger.error("SQL执行出错: " + sqlMapId, e);
                    throw new DatabaseException("SQL执行出错: " + sqlMapId, e);
                }
            }
        });
    }

    /**
     * 删除
     *
     * @param sqlMapId  mybatis映射id
     * @return
     */
    public int delete(final String sqlMapId) {
        return delete(sqlMapId, null);
    }

    /**
     * 带有参数删除
     *
     * @param sqlMapId
     *            mybatis映射id
     * @param param
     *            参数
     * @return
     */
    public int delete(final String sqlMapId, final Object param) {

        return (Integer) execute(new SqlSessionCallback() {

            public Object doInSession(SqlSession session) {
                if (param != null) {
                    return session.delete(sqlMapId, param);
                } else {
                    return session.delete(sqlMapId);
                }
            }
        });
    }

    /**
     * 允许回调,暴露SqlSession给调用者
     *
     * @param action
     * @return
     */
    public Object execute(SqlSessionCallback action) {
        try {
            return action.doInSession(getSqlSession());
        } catch (Exception e) {
            logger.error("Fail to getSqlSession", e);
            throw new DatabaseException("Fail to getSqlSession", e);
        }
    }

    public interface SqlSessionCallback {

        public Object doInSession(SqlSession session);

    }
}