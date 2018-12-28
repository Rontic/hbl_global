package com.hbl.global.service.map.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.map.OrdinaryPoi;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.map.OrdinaryPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrdinaryPoiServiceImpl extends BaseServiceImpl implements OrdinaryPoiService {
    @Autowired
    private CommonDao commonDao;

    @Override
    public List<OrdinaryPoi> getOrdinaryPoi(String cityId) {
        HashMap<String,String> map = new HashMap<>();
        map.put("cityId",cityId);
        return commonDao.selectList("OrdinaryPoi.getOrdinaryPoi",map);
    }

    @Override
    public int insertList(List<OrdinaryPoi> list) {
        return commonDao.save("OrdinaryPoi.insertList",list);
    }
}
