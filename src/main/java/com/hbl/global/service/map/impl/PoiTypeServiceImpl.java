package com.hbl.global.service.map.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.map.PoiType;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.map.PoiTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiTypeServiceImpl extends BaseServiceImpl implements PoiTypeService{

    @Autowired
    private CommonDao commonDao;

    @Override
    public List<PoiType> getPoiTypeList() {
        return commonDao.selectList("PoiType.getPoiType");
    }
}
