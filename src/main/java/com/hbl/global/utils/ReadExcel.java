package com.hbl.global.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcel {
    //读取excel
    public static Workbook readExcel(MultipartFile file){
        Workbook wb = null;
        if(file==null){
            return null;
        }
        InputStream is = null;
        try {
            is = file.getInputStream();
            if("xls".equals(file.getOriginalFilename().split("\\.")[1])){
                return wb = new HSSFWorkbook(is);
            }else if("xlsx".equals(file.getOriginalFilename().split("\\.")[1])){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell) throws Exception{
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellTypeEnum()){
                case NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }
}
