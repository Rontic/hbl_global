package com.hbl.global.controller;

import com.hbl.global.entity.RequestResultModel;
import com.hbl.global.entity.map.OrdinaryPoi;
import com.hbl.global.entity.module.ModuleImage;
import com.hbl.global.entity.module.ModuleRoad;
import com.hbl.global.entity.module.PDFDetail;
import com.hbl.global.service.map.OrdinaryPoiService;
import com.hbl.global.service.module.ModuleItemService;
import com.hbl.global.service.pdfDetail.PDFDetailService;
import com.hbl.global.utils.ReadExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/import/")
public class ImportController extends BaseController{


    @Autowired
    private PDFDetailService pdfDetailService;

    @Autowired
    private OrdinaryPoiService ordinaryPoiService;

    @Autowired
    private ModuleItemService moduleItemService;

    @RequestMapping("importPdf.do")
    @ResponseBody
    public RequestResultModel importPdf(MultipartFile file){
        List<PDFDetail> list = null;
        try {
            Workbook wb =null;
            Sheet sheet = null;
            Row row = null;
            String cellData = null;
            wb = ReadExcel.readExcel(file);
            if(wb != null){
                //用来存放表中数据
                list = new ArrayList<PDFDetail>();
                //获取第一个sheet
                sheet = wb.getSheetAt(0);
                //获取最大行数
                int rownum = sheet.getPhysicalNumberOfRows();
                int colnum = 0;

                for (int i = 1; i<rownum; i++) {
                    row = sheet.getRow(i);
                    if(row !=null){
                        colnum = row.getPhysicalNumberOfCells();
                        PDFDetail pdfDetail = new PDFDetail();
                        for (int j=0;j<colnum;j++){
                            cellData = (String) ReadExcel.getCellFormatValue(row.getCell(j));
                            if(j==0){
                                pdfDetail.setModuleId(cellData);
                            }else if(j==1){
                                pdfDetail.setFileName(cellData);
                            }else if(j==2){
                                pdfDetail.setFileUrl(cellData);
                            }
                        }
                        list.add(pdfDetail);
                    }else{
                        break;
                    }

                }
            }else {
                setErrorResult("读取文件出错");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("读取文件出错");
            return result;
        }

        try {
            int resultNum = pdfDetailService.insertList(list);
            setSuccessResult(null,"成功导入"+resultNum+"条数据");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("数据导入出错");
        }
        return result;
    }

    @RequestMapping("importMap.do")
    @ResponseBody
    public RequestResultModel importMap(MultipartFile file){
        List<OrdinaryPoi> list = null;
        try {
            Workbook wb =null;
            Sheet sheet = null;
            Row row = null;
            String cellData = null;
            wb = ReadExcel.readExcel(file);
            if(wb != null){
                //用来存放表中数据
                list = new ArrayList<OrdinaryPoi>();
                //获取第一个sheet
                sheet = wb.getSheetAt(0);
                //获取最大行数
                int rownum = sheet.getPhysicalNumberOfRows();
                int colnum = 0;

                for (int i = 1; i<rownum; i++) {
                    row = sheet.getRow(i);
                    if(row !=null){
                        colnum = row.getPhysicalNumberOfCells();
                        OrdinaryPoi ordinaryPoi = new OrdinaryPoi();
                        for (int j=0;j<colnum;j++){
                            cellData = (String) ReadExcel.getCellFormatValue(row.getCell(j));
                            if(j==0){
                                ordinaryPoi.setNo(cellData);
                            }else if(j==1){
                                ordinaryPoi.setName(cellData);
                            }else if(j==2){
                                ordinaryPoi.setTypeId(Integer.valueOf(cellData.split("\\.")[0]));
                            }else if(j==3){
                                if(!cellData.equals("")){
                                    ordinaryPoi.setStar(Integer.valueOf(cellData.split("\\.")[0]));
                                }
                            }else if(j==4){
                                if(!cellData.equals("")){
                                    ordinaryPoi.setAddr(cellData);
                                }
                            }else if(j==5){
                                if(!cellData.equals("")){
                                    ordinaryPoi.setTel(cellData);
                                }
                            }else if(j==6){
                                ordinaryPoi.setLon(Double.valueOf(cellData));
                            }else if(j==7){
                                ordinaryPoi.setLat(Double.valueOf(cellData));
                            }else if(j==8){
                                ordinaryPoi.setImages(cellData);
                            }else if(j==9){
                                if(!cellData.equals("")){
                                    ordinaryPoi.setOfficialUrl(cellData);
                                }
                            }else if(j==10){
                                if(!cellData.equals("")){
                                    ordinaryPoi.setSummary(cellData);
                                }
                            }
                        }
                        list.add(ordinaryPoi);
                    }else{
                        break;
                    }

                }
            }else {
                setErrorResult("读取文件出错");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("读取文件出错");
            return result;
        }

        try {
            int resultNum = ordinaryPoiService.insertList(list);
            setSuccessResult(null,"成功导入"+resultNum+"条数据");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("数据导入出错");
        }
        return result;
    }

    @RequestMapping("importRoad.do")
    @ResponseBody
    public RequestResultModel importRoad(MultipartFile file){
        List<ModuleRoad> list = null;
        try {
            Workbook wb =null;
            Sheet sheet = null;
            Row row = null;
            String cellData = null;
            wb = ReadExcel.readExcel(file);
            if(wb != null){
                //用来存放表中数据
                list = new ArrayList<ModuleRoad>();
                //获取第一个sheet
                sheet = wb.getSheetAt(0);
                //获取最大行数
                int rownum = sheet.getPhysicalNumberOfRows();
                int colnum = 0;

                for (int i = 1; i<rownum; i++) {
                    row = sheet.getRow(i);
                    if(row !=null){
                        colnum = row.getPhysicalNumberOfCells();
                        ModuleRoad moduleRoad = new ModuleRoad();
                        for (int j=0;j<colnum;j++){
                            cellData = (String) ReadExcel.getCellFormatValue(row.getCell(j));
                            if(j==0){
                                moduleRoad.setModuleId(cellData);
                            }else if(j==1){
                                moduleRoad.setRoadName(cellData);
                            }else if(j==2){
                                moduleRoad.setStartLon(Double.valueOf(cellData));
                            }else if(j==3){
                                moduleRoad.setStartLat(Double.valueOf(cellData));
                            }else if(j==4){
                                moduleRoad.setEndLon(Double.valueOf(cellData));
                            }else if(j==5){
                                moduleRoad.setEndLat(Double.valueOf(cellData));
                            }
                        }
                        list.add(moduleRoad);
                    }else{
                        break;
                    }

                }
            }else {
                setErrorResult("读取文件出错");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("读取文件出错");
            return result;
        }

        try {
            int resultNum = moduleItemService.insertRoadList(list);
            setSuccessResult(null,"成功导入"+resultNum+"条数据");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("数据导入出错");
        }
        return result;
    }

    @RequestMapping("importImage.do")
    @ResponseBody
    public RequestResultModel importImage(MultipartFile file){
        List<ModuleImage> list = null;
        try {
            Workbook wb =null;
            Sheet sheet = null;
            Row row = null;
            String cellData = null;
            wb = ReadExcel.readExcel(file);
            if(wb != null){
                //用来存放表中数据
                list = new ArrayList<ModuleImage>();
                //获取第一个sheet
                sheet = wb.getSheetAt(0);
                //获取最大行数
                int rownum = sheet.getPhysicalNumberOfRows();
                int colnum = 0;

                for (int i = 1; i<rownum; i++) {
                    row = sheet.getRow(i);
                    if(row !=null){
                        colnum = row.getPhysicalNumberOfCells();
                        ModuleImage moduleImage = new ModuleImage();
                        for (int j=0;j<colnum;j++){
                            cellData = (String) ReadExcel.getCellFormatValue(row.getCell(j));
                            if(j==0){
                                moduleImage.setModuleId(cellData);
                            }else if(j==1){
                                moduleImage.setImageName(cellData);
                            }else if(j==2){
                                moduleImage.setImageName(cellData);
                            }else if(j==3){
                                moduleImage.setContent(cellData);
                            }
                        }
                        list.add(moduleImage);
                    }else{
                        break;
                    }

                }
            }else {
                setErrorResult("读取文件出错");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("读取文件出错");
            return result;
        }

        try {
            int resultNum = moduleItemService.insertImageList(list);
            setSuccessResult(null,"成功导入"+resultNum+"条数据");
        }catch (Exception e){
            e.printStackTrace();
            setErrorResult("数据导入出错");
        }
        return result;
    }
}
