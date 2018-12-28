package com.hbl.global.entity.system;

import com.hbl.global.entity.BaseEntity;

/**
* 字典表; InnoDB free: 3072 kB; (`code_type_id`) REFER `common/tbl_sys_code_type`(`co实体
*
* @author yuanjunchun
*/
public class SysCode extends BaseEntity {

//全局唯一标识 
private static final long serialVersionUID = 3661626200117215428L;

//(主键)
private String codeId;

//
private String codeTypeId;

//
private String codeValue;

//
private Integer codeOrder;

//
private String codeRemark;



/**
* 获取(主键)
* @return  
*/
public String getCodeId(){
 return this.codeId;
}

/**
* 设置(主键)
* @param codeId 
*/
public void setCodeId(String codeId){
 this.codeId = codeId;
}

/**
* 获取
* @return  
*/
public String getCodeTypeId(){
 return this.codeTypeId;
}

/**
* 设置
* @param codeTypeId 
*/
public void setCodeTypeId(String codeTypeId){
 this.codeTypeId = codeTypeId;
}

/**
* 获取
* @return  
*/
public String getCodeValue(){
 return this.codeValue;
}

/**
* 设置
* @param codeValue 
*/
public void setCodeValue(String codeValue){
 this.codeValue = codeValue;
}

/**
* 获取
* @return  
*/
public String getCodeRemark(){
 return this.codeRemark;
}

/**
* 设置
* @param codeRemark 
*/
public void setCodeRemark(String codeRemark){
 this.codeRemark = codeRemark;
}

public Integer getCodeOrder() {
	return codeOrder;
}

public void setCodeOrder(Integer codeOrder) {
	this.codeOrder = codeOrder;
}





}

