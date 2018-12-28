package com.hbl.global.service.map;

import com.hbl.global.entity.map.OrdinaryPoi;
import com.hbl.global.service.base.BaseService;
import java.util.List;

public interface OrdinaryPoiService extends BaseService {

    public List<OrdinaryPoi> getOrdinaryPoi(String cityId);

    public int insertList(List<OrdinaryPoi> list);
}
