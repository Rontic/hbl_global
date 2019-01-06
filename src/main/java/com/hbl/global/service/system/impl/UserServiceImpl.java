package com.hbl.global.service.system.impl;

import com.github.pagehelper.PageInfo;
import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysRole;
import com.hbl.global.entity.system.SysUser;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * 用户管理Service
 * 
 * @author founder
 * 
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public SysUser getUserByUserId(SysUser user) {
		return (SysUser) commonDao.selectOne("SysUser.findSysUser", user);
	}

	@Override
	public List<SysRole> getRoleListByUserId(SysUser user) {
		return commonDao.selectList("SysUser.getRoleListByUserId", user);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateUserAndRoles(SysUser user) {
		commonDao.update("SysUser.updateSysUser", user);
		commonDao.delete("SysUser.deleteSysUserRole", user);
		saveUserRole(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateUser(SysUser user) {
		commonDao.update("SysUser.updateSysUser", user);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void doLogicDeleteUser(SysUser user) {
		commonDao.update("SysUser.logicMultiDeleteRole", user);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void saveUserAndRoles(SysUser user) {
		commonDao.save("SysUser.saveSysUser", user);
		saveUserRole(user);
	}
	
	/**
	 * 保存用户角色信息
	 * @param user
	 */
	private void saveUserRole(SysUser user){
		String roleIds = user.getRoleIds();
		String[] roleIdArray = roleIds.split(",");
		for(int i=0;roleIdArray!=null&&i<roleIdArray.length;i++){
			SysUser userParam = new SysUser();
			userParam.setCreateUser(user.getCreateUser());
			userParam.setUserId(user.getUserId());
			userParam.setRoleId(roleIdArray[i]);
			userParam.setDelFlg("0");
			commonDao.save("SysUser.saveSysUserRole", userParam);
		}
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void saveUser(SysUser user) {
		commonDao.save("SysUser.saveSysUser", user);
	}
	
	@Override
	public List<SysPermiss> getPermissListByUserId(SysUser user) {
		return commonDao.selectList("SysUser.getSysPermissByRoleId", user);

	}

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
	public HashMap<String, Object> getUsers(SysUser param, int pageNo, int pageSize) {
		PageInfo pageInfo = commonDao.pageHelperQuery("SysUser.findSysUser", param, pageNo, pageSize);
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("total", pageInfo.getTotal());
		resMap.put("rows", pageInfo.getList());
		return resMap;
	}
}
