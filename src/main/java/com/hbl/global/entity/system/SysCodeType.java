package com.hbl.global.entity.system;

import com.hbl.global.entity.BaseEntity;

/**
* 字典类型表; InnoDB free: 3072 kB实体
*
* @author yuanjunchun
*/
public class SysCodeType extends BaseEntity {

//全局唯一标识 
private static final long serialVersionUID = 5740985519631628434L;

//(主键)
private String codeTypeId;

//
private String codeTypeValue;

//
private String codeTypeRemark;



/**
* 获取(主键)
* @return  
*/
public String getCodeTypeId(){
 return this.codeTypeId;
}

/**
* 设置(主键)
* @param codeTypeId 
*/
public void setCodeTypeId(String codeTypeId){
 this.codeTypeId = codeTypeId;
}

/**
* 获取
* @return  
*/
public String getCodeTypeValue(){
 return this.codeTypeValue;
}

/**
* 设置
* @param codeTypeValue 
*/
public void setCodeTypeValue(String codeTypeValue){
 this.codeTypeValue = codeTypeValue;
}

/**
* 获取
* @return  
*/
public String getCodeTypeRemark(){
 return this.codeTypeRemark;
}

/**
* 设置
* @param codeTypeRemark 
*/
public void setCodeTypeRemark(String codeTypeRemark){
 this.codeTypeRemark = codeTypeRemark;
}



}
