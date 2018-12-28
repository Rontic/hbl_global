package com.hbl.global.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.system.SysModule;
import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysRole;
import com.hbl.global.entity.system.SysRolePermission;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 角色管理Service
 * 
 * @author founder
 * 
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public List<SysPermiss> getPermissListByRoleId(SysRole role) {
		return commonDao.selectList("SysRole.getSysPermissByRoleId", role);
		
	}
	
	@Override
	public List<SysPermiss> getPermissList() {
		return commonDao.selectList("SysRole.getSysPermiss");
		
	}
	
	
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
	public HashMap<String, Object> getRoles(SysRole param, int pageNo, int pageSize){
		PageInfo pageInfo = commonDao.pageHelperQuery("SysRole.getRoleCounts", param, pageNo, pageSize);
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("total", pageInfo.getTotal());
		resMap.put("rows", pageInfo.getList());
		return resMap;
	}
	
	/**
	 * 获取所有角色
	 * 
	 * @return 所有角色
	 */
	public List<SysRole> findAllRoles(String roleType) {
		return commonDao.selectList("SysRole.getAllRoles",roleType);
	}
	
	/**
	 * 获取所有权限
	 * 
	 * @return 所有权限
	 */
	public List<SysPermiss> findAllPermissions(){
		return commonDao.selectList("SysRole.getSysPermiss");
	}
	
	
	public List<SysModule> findAllModuleIds(){
		return commonDao.selectList("SysRole.getSysModuleIds");
	}
	
	/**
	 * 获取用户关联权限
	  * @param roleId
	 *            角色Id
	 * @return 用户关联权限
	 */
	public List<String> findPermissionsByRoleId(String roleId){
		return commonDao.selectList("SysRole.getSysPermissIdsByRoleId",roleId);
	}
	
	/**
	 * 获取角色数量
	 * 
	 * @param role
	 *            角色信息
	 * @return 角色数量
	 */
	public Integer getRoleByRoleOrder(SysRole role) {
		return (Integer) commonDao.selectOne("SysRole.getRoleByRoleOrder",
				role);
	}
	
	/**
	 * 获取重复角色数量
	 * 
	 * @param role
	 *            角色信息
	 * @return 角色数量
	 */
	public Integer getRepeatRoleByRoleOrder(SysRole role) {
		return (Integer) commonDao.selectOne("SysRole.getRepeatRoleByRoleOrder",
				role);
	}
	
	/**
	 * 更新角色信息
	 * 
	 * @param role
	 *            角色信息
	 */
	public void updateRole(SysRole role) {
		commonDao.update("SysRole.updateRole", role);
		updateRolePermission(role);
	}
	
	
	/**
	 * 更新角色权限
	 * 
	 * @param role
	 *            角色信息
	 */
	public void updateRolePermission(SysRole role) {
		deleteRolePermissionByRoleIs(role.getRoleId());
		List<SysRolePermission> rolePermissionList  = new ArrayList<SysRolePermission>();
		if(null!=role.getPermissionIds()&&!"".equals(role.getPermissionIds())){
		    for(String pers :role.getPermissionIds()){
		    	SysRolePermission rolePerm = new SysRolePermission();
		    	rolePerm.setDelFlg("0");
		    	rolePerm.setPermissionId(pers);
		    	rolePerm.setRoleId(role.getRoleId());
		    	rolePermissionList.add(rolePerm);
		    }
		    saveRolePermission(rolePermissionList);
		}
	}
	
	
	/**
	 * 删除角色权限
	 * 
	 * @param roleId
	 *            角色信息
	 */
	public void deleteRolePermissionByRoleIs(String roleId){
		commonDao.delete("SysRole.deleteRolePermissionByRoleIs", roleId);
		
		
	}
	
	
	/**
	 * 保存角色
	 * 
	 * @param role
	 *            角色信息
	 */
	public void saveRole(SysRole role) {
		commonDao.save("SysRole.saveRole", role);
		List<SysRolePermission> rolePermissionList  = new ArrayList<SysRolePermission>();
		if(null!=role.getPermissionIds()&&role.getPermissionIds().length>0&&!"".equals(role.getPermissionIds())){
		    for(String pers :role.getPermissionIds()){
		    	SysRolePermission rolePerm = new SysRolePermission();
		    	rolePerm.setDelFlg("0");
		    	rolePerm.setPermissionId(pers);
		    	rolePerm.setRoleId(role.getRoleId());
		    	rolePermissionList.add(rolePerm);
		    }
		    saveRolePermission(rolePermissionList);
		}
	}
	
	
	public void saveRolePermission(List<SysRolePermission> rolePermissionList){
		commonDao.save("SysRole.saveRolePermission", rolePermissionList);
	}
	
	/**
	 * 删除角色
	 * 
	 * @param role
	 *            角色信息
	 */
	public void doMultiLogicDelRole(SysRole role) {
		deleteRolePermissionByRoleIs(role.getRoleId());
		commonDao.update("SysRole.logicMultiDeleteRole", role);
	}

	
	
}
