package com.hbl.global.dao;

import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

/**
 * 基础数据访问对象接口
 * 
 * @author founder
 * 
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 保存
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param parames
	 *            SQL语句参数
	 */
	public int save(String sqlName, Object parames);

	/**
	 * 保存
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param paramList
	 *            SQL语句参数
	 */
	public int save(String sqlName, List paramList);

	/**
	 * 更新
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param paramList
	 *            SQL语句参数
	 */
	public int update(String sqlName, List paramList);

	/**
	 * 更新
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param parames
	 *            SQL语句参数
	 */
	public int update(String sqlName, Object parames);

	/**
	 * 更新
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param parames
	 *            SQL语句参数
	 */
	public int update(String sqlName, Map parames);

	/**
	 * 删除
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param id
	 *            SQL语句参数
	 */
	public int delete(String sqlName, String id);

	/**
	 * 删除
	 *
	 * @param sqlName
	 *            SQL语句ID
	 * @param param
	 *            SQL语句参数
	 */
	public int delete(String sqlName, Object param);

	/**
	 * 查询单条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @return 查询结果
	 */
	public T selectOne(String sqlName);

	/**
	 * 查询单条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 * @return 查询结果
	 */
	public T selectOne(String sqlName, Object params);

	/**
	 * 查询多条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @return 查询结果
	 */
	public List<T> selectList(String sqlName);

	/**
	 * 查询多条记录
	 * 
	 * @param sqlName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 * @return 查询结果
	 */
	public List<T> selectList(String sqlName, Object params);
	
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
	public List<T> selectList(String sqlName, Object params, int pageNo, int pageSize);

	/**
	 * 执行存储过程
	 * 
	 * @param produceName
	 *            SQL语句ID
	 * @param params
	 *            SQL语句参数
	 */
	public void invokeProduce(String produceName, Map<String, Object> params);

	public PageInfo pageHelperQuery(String sqlKey, Object param, Integer pageNo, Integer pageSize);

}
