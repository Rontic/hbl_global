package com.hbl.global.service.system;

import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysRole;
import com.hbl.global.entity.system.SysUser;
import com.hbl.global.service.base.BaseService;
import java.util.HashMap;
import java.util.List;

/**
 * 用户管理Service接口
 * 
 * @author founder
 * 
 */
public interface UserService extends BaseService {

	/**
	 * 获取用户信息
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户信息
	 */
	public SysUser getUserByUserId(SysUser sysUser);

	/**
	 * 通过用户得到角色信息
	 * 
	 * @param id 用户ID
	 * @return 用户信息
	 */
	public List<SysRole> getRoleListByUserId(SysUser user);

	/**
	 * 更新用户信息和角色信息
	 * @param user
	 */
	public void updateUserAndRoles(SysUser user);
	
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 */
	public void updateUser(SysUser user);
	
	/**
	 * 逻辑删除用户（将del_flg置为1）
	 * @param user
	 */
	public void doLogicDeleteUser(SysUser user);
	/**
	 * 保存用户信息
	 * @param user
	 */
	public void saveUser(SysUser user);
	
	/**
	 * 保存用户信息和角色信息
	 * @param user
	 */
	public void saveUserAndRoles(SysUser user);

	/**
	 * 获得用户的特有权限
	 * 
	 * @param role
	 * @return
	 */
	public List<SysPermiss> getPermissListByUserId(SysUser user);

	/**
	 * 获取分页用户
	 * 
	 * @param param
	 *            查询参数
	 * @param pageNo
	 *            页数
	 * @param pageSize
	 *            每页记录数
	 * @return 分页用户
	 */
	public HashMap<String, Object> getUsers(SysUser param, int pageNo, int pageSize);
}
