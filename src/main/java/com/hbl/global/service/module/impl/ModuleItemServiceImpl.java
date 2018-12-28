package com.hbl.global.service.module.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.module.ModuleFile;
import com.hbl.global.entity.module.ModuleImage;
import com.hbl.global.entity.module.ModuleRoad;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.module.ModuleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleItemServiceImpl extends BaseServiceImpl implements ModuleItemService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public ModuleFile getFileType(String moduleId) {
        return (ModuleFile) commonDao.selectOne("ModuleFile.getFileType",moduleId);
    }

    @Override
    public List<ModuleImage> getImageList(String moduleId) {
        return commonDao.selectList("ModuleImage.selectImageList",moduleId);
    }

    @Override
    public List<ModuleRoad> getRoadList(String moduleId) {
        return commonDao.selectList("ModuleRoad.selectRoadList",moduleId);
    }

    @Override
    public int insertImageList(List<ModuleImage> list) {
        return commonDao.save("ModuleImage.insertList",list);
    }

    @Override
    public int insertRoadList(List<ModuleRoad> list) {
        return commonDao.save("ModuleRoad.insertList",list);
    }
}
