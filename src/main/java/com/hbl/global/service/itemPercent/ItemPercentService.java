package com.hbl.global.service.itemPercent;

import com.hbl.global.entity.statistics.ItemPercent;
import com.hbl.global.service.base.BaseService;
import java.util.HashMap;
import java.util.List;

public interface ItemPercentService extends BaseService {

    public int saveItemPercent(List<ItemPercent> itemPercents);

    public HashMap<String,Object> getItemPercentData(HashMap<String,String> tempMap,String code);
}
