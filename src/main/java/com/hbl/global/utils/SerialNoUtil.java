package com.hbl.global.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 序号工具类
 * 
 * @author founder
 * 
 */
public final class SerialNoUtil {

    private SerialNoUtil() {

    }

    // 数据表编号
    private static Map<String, String> tableSeqenceMap = new HashMap<String, String>() {
        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = 4688443584905462104L;

        {
            /*
             * 编号第一位数字 系统表: 1:system 2:member 3:info 4:cms 5:creeper(数据采集)
             */

            // common start
            put("tbl_sys_user", "100");
            put("tbl_sys_role", "101");
            put("tbl_sys_role_user", "102");
            put("tbl_sys_role_permission", "103");
            put("tbl_sys_code", "104");

            put("tbl_gdp", "200");
            put("tbl_file", "201");
        }

    };

    /**
     * 获取表的主键值
     * 
     * @param tableName
     *            表名
     * @return 表的主键值
     */
    public static String getTabPkSn(String tableName) {

        String tableSeqence = tableSeqenceMap.get(tableName.toLowerCase());
        if (tableSeqence == null) {
            throw new RuntimeException();
        }

        String milliseconds = String.valueOf(new Date().getTime());

        return tableSeqence
                + milliseconds.substring(milliseconds.length() - 12)
                + RandomUtils.generateNumberString(5);

    }
    
    public static String getOrderPKSn(){
    	String milliseconds = String.valueOf(new Date().getTime());
        return milliseconds.substring(milliseconds.length() - 12)
                + RandomUtils.generateNumberString(4);
    }
}
