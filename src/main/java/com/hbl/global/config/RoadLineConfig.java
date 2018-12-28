package com.hbl.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RoadLineConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pdfFile/**").addResourceLocations("file:/F:/workTemp/pdf/");
        registry.addResourceHandler("/wholePictures/**").addResourceLocations("file:/F:/workTemp/wholePictures/huangpi/");
        registry.addResourceHandler("/image/**").addResourceLocations("file:/F:/workTemp/image/");
        //registry.addResourceHandler("/pdfFile/**").addResourceLocations("file:/C:/PROJECT/fileFolder/pdf/");
        //super.addResourceHandlers(registry);
    }
}
