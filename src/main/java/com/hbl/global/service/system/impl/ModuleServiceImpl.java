package com.hbl.global.service.system.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.module.BaseModule;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.system.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class ModuleServiceImpl extends BaseServiceImpl implements ModuleService {
    @Autowired
    private CommonDao commonDao;

    @Override
    public List<BaseModule> getItemList(String parentId) {
        return commonDao.selectList("SysModule.getItemList", parentId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int editPoint(BaseModule baseModule) {
        return commonDao.update("SysModule.editPoint",baseModule);
    }

    @Override
    public List<HashMap> getMainData() {
        return commonDao.selectList("SysModule.getMainData");
    }

    @Override
    public String getRealPoint() {
        return (String) commonDao.selectOne("SysModule.selectRealPoint");
    }
}
