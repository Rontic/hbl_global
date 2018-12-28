package com.hbl.global.dao.impl;

import com.hbl.global.dao.BaseDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 基础数据访问对象
 * 
 * @author founder
 * 
 * @param <T>
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

	private static final Log log = LogFactory.getLog(BaseDaoImpl.class);

	@Resource
	public final void setSqlSessionFactory(SqlSessionFactory mysqlSqlSessionFactory){
		super.setSqlSessionFactory(mysqlSqlSessionFactory);
	}

	/**
	 * 保存
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param parames
	 *            SQL语句参数
	 */
	public int save(String sqlName, Object parames) {
        int result = 0;
        try {
            result = getSqlSession().insert(sqlName, parames);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 保存
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param paramList
	 *            SQL语句参数
	 */
	public int save(String sqlName, List paramList) {

		int result = 0;
		try {
			result = getSqlSession().insert(sqlName, paramList);
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 更新
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param parames
	 *            SQL语句参数
	 */
	public int update(String sqlName, Object parames) {
        int result = 0;
        try {
            result = getSqlSession().update(sqlName, parames);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 更新
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param parames
	 *            SQL语句参数
	 */
	public int update(String sqlName, Map parames) {
        int result = 0;
        try {
            result = getSqlSession().update(sqlName, parames);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 更新
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param paramList
	 *            SQL语句参数
	 */
	public int update(String sqlName, List paramList) {
        int result = 0;
        try {
            result = getSqlSession().update(sqlName, paramList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 查询单条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public T selectOne(String sqlName) {
        T result = null;
        try {
            result = (T)getSqlSession().selectOne(sqlName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 查询单条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public T selectOne(String sqlName, Object params) {
        T result = null;
        try {
            result = (T)getSqlSession().selectOne(sqlName,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 查询多条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public List<T> selectList(String sqlName) {
        List<T>  result = null;
        try {
            result = (List<T>) getSqlSession().selectList(sqlName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 查询多条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public List<T> selectList(String sqlName, Object params) {
        List<T>  result = null;
        try {
            result = (List<T>) getSqlSession().selectList(sqlName,params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}
	
	/**
	 * 查询多条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 * @param pageNo
	 *            需要查询的实际页
	 * @param pageSize
	 *            每页记录行数
	 * @return 查询结果
	 */
	@SuppressWarnings("unchecked")
	public List<T> selectList(String sqlName, Object params, int pageNo, int pageSize) {
        List<T> result = null;
        try {
            PageHelper.startPage(pageNo,pageSize);
            List<Object> emps = getSqlSession().selectList(sqlName,params);
            PageInfo pageInfo = new PageInfo(emps);
            result = pageInfo.getList();
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 删除
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param id
	 *            SQL语句参数
	 */
	public int delete(String sqlName, String id) {
        int result = 0;
		try {
            result = getSqlSession().delete(sqlName, id);
        }catch (Exception e){
		    e.printStackTrace();
        }
        return result;
	}

	/**
	 * 删除
	 *
	 * @param sqlName
	 *            SQL语句ID
	 * @param o
	 *            SQL语句参数
	 */
	public int delete(String sqlName, Object o) {
        int result = 0;
        try {
            result = getSqlSession().delete(sqlName, o);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 执行存储过程
	 * 
	 * @param produceName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 */
	public void invokeProduce(String produceName, Map<String, Object> params) {
		try {
			getSqlSession().insert(produceName, params);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public PageInfo pageHelperQuery(String sqlKey, Object param, Integer pageNo, Integer pageSize) {
		PageInfo result = null;
		try {
			PageHelper.startPage(pageNo-1,pageSize);
			List<T> emps = getSqlSession().selectList(sqlKey,param);
			result = new PageInfo(emps);
			return result;
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
