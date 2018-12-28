package com.hbl.global.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 资源文件读取工具类
 * 
 * @author founder
 * 
 */
public final class PropertiesUtil {

    private PropertiesUtil() {

    }

    /**
     * 读取资源文件
     * 
     * @param fileName
     *            资源文件名
     * @return 资源文件
     */
    public static Properties loadProperties(String fileName) {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        Properties p = new Properties();
        try {
            inputStream = PropertiesUtil.class.getClassLoader()
                    .getResourceAsStream(fileName);
            inputStreamReader = new InputStreamReader(PropertiesUtil.class.getClassLoader()
                    .getResourceAsStream(fileName),"UTF-8");
            //p.load(inputStream);
            p.load(inputStreamReader);
        } catch (IOException e) {
           e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return p;
    }


}
