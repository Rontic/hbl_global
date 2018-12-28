package com.hbl.global.entity.map;

import com.hbl.global.utils.PropertiesUtil;

import java.util.Properties;

public class PoiType {

    private static Properties iconProperties = PropertiesUtil.loadProperties("property/poiTypeIcon.properties");
    private static Properties colorProperties = PropertiesUtil.loadProperties("property/poiColor.properties");

    private String id;

    private String name;

    private String icon;

    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        setIcon(iconProperties.getProperty(id));
        setColor(colorProperties.getProperty(id));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
