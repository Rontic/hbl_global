package com.hbl.global.service.system;

import com.hbl.global.entity.module.BaseModule;
import com.hbl.global.service.base.BaseService;

import java.util.HashMap;
import java.util.List;

public interface ModuleService extends BaseService{
    public List<BaseModule> getItemList(String parentId);

    public int editPoint(BaseModule baseModule);

    public List<HashMap> getMainData();

    public String getRealPoint();
}
