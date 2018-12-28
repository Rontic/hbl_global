package com.hbl.global.service.system;

import com.hbl.global.entity.system.SysModule;
import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysRole;
import com.hbl.global.entity.system.SysRolePermission;
import com.hbl.global.service.base.BaseService;
import java.util.HashMap;
import java.util.List;

/**
 * 角色管理Service接口
 * 
 * @author founder
 * 
 */
public interface RoleService extends BaseService {

	/**
	 * 通过角色ID得到权限信息
	 * 
	 * @param role 用户ID
	 * @return 用户信息
	 */
	public List<SysPermiss> getPermissListByRoleId(SysRole role);
	
	
	/**
	 * 所有权限信息
	 * 
	 * @return 用户信息
	 */
	public List<SysPermiss> getPermissList();

	/**
	 * 获取分页角色
	 * 
	 * @param param
	 *            查询参数
	 * @param pageNo
	 *            页数
	 * @param pageSize
	 *            每页记录数
	 * @return 分页角色
	 */
	public HashMap<String, Object> getRoles(SysRole param, int pageNo, int pageSize);
	
	/**
	 * 获取所有角色
	 * 
	 * @param roleType
	 *            系统编号
	 * @return 所有角色
	 */
	public List<SysRole> findAllRoles(String roleType);
	
	/**
	 * 获取所有权限
	 * 
	 * @return 所有权限
	 */
	public List<SysPermiss> findAllPermissions();
	
	public List<SysModule> findAllModuleIds();
	
	/**
	 * 获取角色数量
	 * 
	 * @param role
	 *            角色信息
	 * @return 角色数量
	 */
	public Integer getRoleByRoleOrder(SysRole role);
	
	/**
	 * 获取重复角色数量
	 * 
	 * @param role
	 *            角色信息
	 * @return 角色数量
	 */
	public Integer getRepeatRoleByRoleOrder(SysRole role);
	
	/**
	 * 更新角色信息
	 * 
	 * @param role
	 *            角色信息
	 */
	public void updateRole(SysRole role);
	
	
	/**
	 * 更新角色权限
	 * 
	 * @param role
	 *            角色信息
	 */
	public void updateRolePermission(SysRole role);
	
	/**
	 * 保存角色
	 * 
	 * @param role
	 *            角色信息
	 */
	public void saveRole(SysRole role);
	
	
	public void saveRolePermission(List<SysRolePermission> rolePermissionList);
	
	/**
	 * 删除角色
	 * 
	 * @param role
	 *            角色信息
	 */
	public void doMultiLogicDelRole(SysRole role);
	
	/**
	 * 获取用户关联权限
	  * @param roleId
	 *            角色Id
	 * @return 用户关联权限
	 */
	public List<String> findPermissionsByRoleId(String roleId);
	
	/**
	 * 删除角色权限
	 * 
	 * @param roleId
	 *            角色信息
	 */
	public void deleteRolePermissionByRoleIs(String roleId);
	
}
