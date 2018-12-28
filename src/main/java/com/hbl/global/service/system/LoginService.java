package com.hbl.global.service.system;

import com.hbl.global.entity.system.SysModule;
import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysUser;
import java.util.List;
import java.util.Map;

/**
 * 系统管理Service接口
 * 
 * @author founder
 * 
 */
public interface LoginService {

	/**
	 * 验证用户信息
	 * 
	 * @param dto 登陆信息
	 * @return 用户信息
	 */
	public SysUser checkAuth(SysUser sysUser);

	/**
	 * 通过权限获得模块信息
	 * @param sysPermiss
	 * @return
	 */
	public List<SysModule> getModuleListByPermissIds(SysPermiss sysPermiss);
	/**
	 * 获取模块列表
	 * 
	 * @param module 模块信息
	 * @return 模块列表
	 */
	public List<SysModule> getModulesByParent(SysModule module);
		
	/**
	 * 根据一组id，父id查询module
	 * 
	 * @param param
	 *            查询条件
	 * @return 模块列表
	 */
	public List<SysModule> getByIdsAndParentId(Map<String, Object> param);
}
