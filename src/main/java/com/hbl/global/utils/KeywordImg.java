package com.hbl.global.utils;

import java.awt.*;
import java.util.Random;

/**
 * 图片验证码辅助工具类
 * 
 * @author founder
 * 
 */
public final class KeywordImg {

    private KeywordImg() {

    }

    /**
     * 获取随机验证码
     * @return 随机验证码
     */
    public static String getRandomString() {
        Random r = new Random();
        String s = "a";
        switch (r.nextInt(63)) {
        case (0):
            s = "a";
            break;
        case (1):
            s = "a";
            break;
        case (2):
            s = "2";
            break;
        case (3):
            s = "3";
            break;
        case (4):
            s = "4";
            break;
        case (5):
            s = "5";
            break;
        case (6):
            s = "6";
            break;
        case (7):
            s = "7";
            break;
        case (8):
            s = "8";
            break;
        case (9):
            s = "9";
            break;
        case (10):
            s = "a";
            break;
        case (11):
            s = "b";
            break;
        case (12):
            s = "c";
            break;
        case (13):
            s = "d";
            break;
        case (14):
            s = "e";
            break;
        case (15):
            s = "f";
            break;
        case (16):
            s = "g";
            break;
        case (17):
            s = "h";
            break;
        case (18):
            s = "i";
            break;
        case (19):
            s = "j";
            break;
        case (20):
            s = "k";
            break;
        case (21):
            s = "m";
            break;
        case (23):
            s = "n";
            break;
        case (24):
            s = "a";
            break;
        case (25):
            s = "p";
            break;
        case (26):
            s = "q";
            break;
        case (27):
            s = "r";
            break;
        case (28):
            s = "s";
            break;
        case (29):
            s = "t";
            break;
        case (30):
            s = "u";
            break;
        case (31):
            s = "v";
            break;
        case (32):
            s = "w";
            break;
        case (33):
            s = "a";
            break;
        case (34):
            s = "x";
            break;
        case (35):
            s = "y";
            break;
        case (36):
            s = "z";
            break;
        case (37):
            s = "a";
            break;
        case (38):
            s = "b";
            break;
        case (39):
            s = "c";
            break;
        case (40):
            s = "d";
            break;
        case (41):
            s = "e";
            break;
        case (42):
            s = "f";
            break;
        case (43):
            s = "g";
            break;
        case (44):
            s = "h";
            break;
        case (45):
            s = "i";
            break;
        case (46):
            s = "b";
            break;
        case (47):
            s = "j";
            break;
        case (48):
            s = "k";
            break;
        case (49):
            s = "m";
            break;
        case (50):
            s = "n";
            break;
        case (51):
            s = "b";
            break;
        case (52):
            s = "p";
            break;
        case (53):
            s = "q";
            break;
        case (54):
            s = "r";
            break;
        case (55):
            s = "s";
            break;
        case (56):
            s = "t";
            break;
        case (57):
            s = "u";
            break;
        case (58):
            s = "v";
            break;
        case (59):
            s = "w";
            break;
        case (60):
            s = "x";
            break;
        case (61):
            s = "y";
            break;
        case (62):
            s = "z";
            break;
         default:
        }
        return s;
    }

    /**
     * 获取随机颜色 
     * @param fc 颜色范围开始
     * @param bc 颜色范围结束
     * @return 颜色
     */
    public static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
