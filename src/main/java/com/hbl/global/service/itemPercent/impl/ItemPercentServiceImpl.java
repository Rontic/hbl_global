package com.hbl.global.service.itemPercent.impl;

import com.hbl.global.dao.commonDao.CommonDao;
import com.hbl.global.entity.statistics.ItemPercent;
import com.hbl.global.service.base.impl.BaseServiceImpl;
import com.hbl.global.service.itemPercent.ItemPercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemPercentServiceImpl extends BaseServiceImpl implements ItemPercentService {

    @Autowired
    private CommonDao commonDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int saveItemPercent(List<ItemPercent> itemPercents) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("itemPercents",itemPercents);
        return commonDao.save("ItemPercent.saveItemPercents",map);
    }

    @Override
    public HashMap<String, Object> getItemPercentData(HashMap<String,String> tempMap,String code) {
        HashMap<String,Object> resultMap = new HashMap<>();
        List<ItemPercent> dataList = commonDao.selectList("ItemPercent.getItemPercentList",tempMap);
        if("single".equals(code)){
            List<String> yearList = new ArrayList<>();
            List<Integer> totalList = new ArrayList<>();
            List<Integer> itemList = new ArrayList<>();
            for(int i=0;i<dataList.size();i++){
                yearList.add(dataList.get(i).getDataYear());
                totalList.add(Integer.valueOf(dataList.get(i).getTotalAmount()));
                itemList.add(Integer.valueOf(dataList.get(i).getItemAmount()));
            }
            resultMap.put("yearList",yearList);
            resultMap.put("totalList",totalList);
            resultMap.put("itemList",itemList);
        }else if("double".equals(code)){
            List<String> yearList = new ArrayList<>();
            List<Integer> totalList = new ArrayList<>();
            List<Integer> itemList = new ArrayList<>();
            List<Integer> newTotalList = new ArrayList<>();
            List<Integer> newItemList = new ArrayList<>();
            for(int i=0;i<dataList.size();i++){
                if("1".equals(dataList.get(i).getStatisticType())){
                    yearList.add(dataList.get(i).getDataYear());
                    totalList.add(Integer.valueOf(dataList.get(i).getTotalAmount()));
                    itemList.add(Integer.valueOf(dataList.get(i).getItemAmount()));
                }else{
                    newTotalList.add(Integer.valueOf(dataList.get(i).getTotalAmount()));
                    newItemList.add(Integer.valueOf(dataList.get(i).getItemAmount()));
                }
            }
            resultMap.put("yearList",yearList);
            resultMap.put("totalList",totalList);
            resultMap.put("itemList",itemList);
            resultMap.put("newTotalList",newTotalList);
            resultMap.put("newItemList",newItemList);
        }
        return resultMap;
    }
}
