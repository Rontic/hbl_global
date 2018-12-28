package com.hbl.global.service.system.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.system.SysModule;
import com.hbl.global.entity.system.SysPermiss;
import com.hbl.global.entity.system.SysUser;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.system.LoginService;
import com.hbl.global.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * 系统管理Service
 * 
 * @author founder
 * 
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

	@Autowired
	private CommonDao commonDao;

	@Override
	public SysUser checkAuth(SysUser sysUser) {
		if (null != sysUser.getPassword()) {
			sysUser.setPassword(MD5.MD5Encode(sysUser.getPassword().trim()));
		}
		SysUser user = (SysUser) commonDao.selectOne("SysUser.findSysUser", sysUser);

		return user;
	}

	@Override
	public List<SysModule> getModuleListByPermissIds(SysPermiss sysPermiss) {
		return (List<SysModule>) commonDao.selectList("SysModule.getModuleListByPermissIds",sysPermiss);
	}
	
	/**
	 * 获取模块列表
	 * 
	 * @param module
	 *            模块信息
	 * @return 模块列表
	 */
	public List<SysModule> getModulesByParent(SysModule module) {
		return (List<SysModule>) commonDao.selectList("System.getByParentModule",module);
	}

	/**
	 * 根据一组id，父id查询module
	 * 
	 * @param param
	 *            查询条件
	 * @return 模块列表
	 */
	public List<SysModule> getByIdsAndParentId(Map<String, Object> param) {

		return (List<SysModule>) commonDao.selectList("System.getTopModules",param);
	}

}
