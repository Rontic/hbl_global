package com.hbl.global.service.map;

import com.hbl.global.entity.map.PoiType;
import com.hbl.global.service.base.BaseService;
import java.util.List;

public interface PoiTypeService extends BaseService {
    public List<PoiType> getPoiTypeList();
}
