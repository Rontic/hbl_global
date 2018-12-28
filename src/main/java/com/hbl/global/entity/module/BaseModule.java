package com.hbl.global.entity.module;

public class BaseModule {
    private String moduleId;
    private String parentId;
    private String moduleName;
    private int totalPoint;
    private int realPoint;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getRealPoint() {
        return realPoint;
    }

    public void setRealPoint(int realPoint) {
        this.realPoint = realPoint;
    }
}
