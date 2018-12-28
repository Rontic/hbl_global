package com.hbl.global.service.module;

import com.hbl.global.entity.module.ModuleFile;
import com.hbl.global.entity.module.ModuleImage;
import com.hbl.global.entity.module.ModuleRoad;
import com.hbl.global.service.base.BaseService;

import java.util.List;

public interface ModuleItemService extends BaseService{
    public ModuleFile getFileType(String moduleId);

    public List<ModuleImage> getImageList(String moduleId);

    public List<ModuleRoad> getRoadList(String moduleId);

    public int insertImageList(List<ModuleImage> list);

    public int insertRoadList(List<ModuleRoad> list);
}
