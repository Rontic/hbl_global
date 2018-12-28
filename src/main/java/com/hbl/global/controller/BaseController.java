package com.hbl.global.controller;

import com.hbl.global.entity.RequestResultModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class BaseController {
    protected final Log logger = LogFactory.getLog(BaseController.class);

    protected RequestResultModel result = new RequestResultModel();

    protected HashMap<String,Object> pageResult = new HashMap<String,Object>();

    public BaseController(){

    }

    public void setSuccessResult(Object data,String message){
        result.setData(data);
        result.setStatu(200);
        result.setMsg(message);
        result.setSuccess(true);
    }

    public void setErrorResult(String message){
        result.setStatu(500);
        result.setMsg(message);
        result.setSuccess(false);
    }

    public void setPageResult(HashMap<String,Object> map){
        pageResult = map;
        pageResult.put("status",200);
    }
}
