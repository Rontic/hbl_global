package com.hbl.global.controller.module;


import com.hbl.global.controller.BaseController;
import com.hbl.global.entity.RequestResultModel;
import com.hbl.global.entity.map.OrdinaryPoi;
import com.hbl.global.entity.map.PoiType;
import com.hbl.global.entity.module.*;
import com.hbl.global.service.itemPercent.ItemPercentService;
import com.hbl.global.service.map.OrdinaryPoiService;
import com.hbl.global.service.map.PoiTypeService;
import com.hbl.global.service.module.ModuleItemService;
import com.hbl.global.service.pdfDetail.PDFDetailService;
import com.hbl.global.service.system.ModuleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/moduleShow/")
public class ModuleShowController extends BaseController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private ModuleItemService moduleItemService;

    @Autowired
    private PDFDetailService pdfDetailService;

    @Autowired
    private ItemPercentService itemPercentService;

    @Autowired
    private PoiTypeService poiTypeService;

    @Autowired
    private OrdinaryPoiService ordinaryPoiService;

    @RequestMapping("list.do")
    public ModelAndView list(ModelAndView  modelAndView, HttpServletRequest request){
        modelAndView.setViewName("page/module/moduleList.html");
        modelAndView.addObject("moduleId",request.getParameter("moduleId"));
        modelAndView.addObject("moduleName",request.getParameter("moduleName"));
        return modelAndView;
    }

    @RequestMapping("getItemList.do")
    @ResponseBody
    public RequestResultModel getItem(String moduleId){
        try {
            List<BaseModule> itemList = moduleService.getItemList(moduleId);
            setSuccessResult(itemList,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("查询出错");
        }

        return result;
    }

    @RequestMapping(value="editPoint.do",consumes = "application/json;charset=utf-8")
    @ResponseBody
    public RequestResultModel editPoint(@RequestBody BaseModule baseModule){
        try {
            moduleService.editPoint(baseModule);
            setSuccessResult(null,"更新成功!");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("更新失败!");
        }
        return result;
    }

    @RequestMapping("getModuleData.do")
    @ResponseBody
    public RequestResultModel getModuleData(HttpServletRequest request){
        try{
            String moduleId = request.getParameter("moduleId");
            ModuleFile moduleFile = moduleItemService.getFileType(moduleId);
            HashMap<String,Object> dataMap = new HashMap<>();
            HashMap<String,String> parameMap = new HashMap<>();
            parameMap.put("moduleId", moduleId);
            if(moduleFile.getFileFlg() == 1){
                List<PDFDetail> pdfDetails = pdfDetailService.getPDFlist(moduleId);
                dataMap.put("pdfDetails",pdfDetails);
                dataMap.put("pdfFlg",true);
            }else{
                dataMap.put("pdfFlg",false);
            }

            if(moduleFile.getStatisticsFlg() == 1){
                HashMap<String,Object> itemPercentMap = new HashMap<>();
                if(moduleFile.getStatisticsType() ==1 || moduleFile.getStatisticsType() ==2){
                    itemPercentMap = itemPercentService.getItemPercentData(parameMap,"single");
                }else if(moduleFile.getStatisticsType() == 11){
                    itemPercentMap = itemPercentService.getItemPercentData(parameMap,"double");
                }
                itemPercentMap.put("dataTitle",moduleFile.getStatisticsName());
                itemPercentMap.put("type",moduleFile.getStatisticsType());
                dataMap.put("itemPercentMap",itemPercentMap);
                dataMap.put("statisticsFlg",true);
            }else{
                dataMap.put("statisticsFlg",false);
            }

            if(moduleFile.getMapFlg() == 1){
                List<PoiType> poiTypes = poiTypeService.getPoiTypeList();
                List<OrdinaryPoi> ordinaryPois = ordinaryPoiService.getOrdinaryPoi("");
                HashMap<String,Object> mapData = new HashMap<>();
                mapData.put("poiTypes",poiTypes);
                mapData.put("ordinaryPois",ordinaryPois);
                //String  mapHistory = PropertiesUtil.loadProperties("property/historyDo.properties").getProperty("mapHistory");
                String mapHistory = null;
                if(mapHistory!=null){
                    mapData.put("mapType",union(moduleFile.getMapCode().split(","),mapHistory.split(",")));
                }else{
                    mapData.put("mapType",moduleFile.getMapCode());
                }
                dataMap.put("mapData",mapData);
                dataMap.put("mapFlg",true);
            }else{
                dataMap.put("mapFlg",false);
            }

            if(moduleFile.getRoadFlg() == 1){
                List<ModuleRoad> roadDetails = moduleItemService.getRoadList(moduleId);
                dataMap.put("roadDetails",roadDetails);
                dataMap.put("roadFlg",true);
            }else{
                dataMap.put("roadFlg",false);
            }

            if(moduleFile.getImageFlg() == 1){
                List<ModuleImage> imageDetails = moduleItemService.getImageList(moduleId);
                dataMap.put("imageDetails",imageDetails);
                dataMap.put("imageFlg",true);
            }else{
                dataMap.put("imageFlg",false);
            }
            setSuccessResult(dataMap,"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("查询失败");
        }
        return result;
    }

    @RequestMapping("goFile.do")
    public ModelAndView goFile(ModelAndView  modelAndView, HttpServletRequest request){
        modelAndView.setViewName("page/module/moduleShow.html");
        modelAndView.addObject("moduleId",request.getParameter("moduleId"));
        return modelAndView;
    }

    @RequestMapping(value="getMainData.do")
    @ResponseBody
    public RequestResultModel getMainData(){
        try {
            setSuccessResult(moduleService.getMainData(),"查询成功");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("查询出错");
        }
       return result;
    }


    public String union(String[] array1,String[] array2){
        Set<String> set = new HashSet<String>();
        for (String str : array1) {
            set.add(str);
        }
        for (String str : array2) {
            set.add(str);
        }
        String[] result = {};
        return StringUtils.join(set.toArray(result),",");
    }
}
