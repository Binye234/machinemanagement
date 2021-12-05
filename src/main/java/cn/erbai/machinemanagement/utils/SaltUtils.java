package cn.erbai.machinemanagement.utils;

import java.security.SecureRandom;

/**
 * @description:生成盐工具类
 * @author: boood
 * @time: 2021/12/5 12:52
 */
public class SaltUtils {
    private static char[] chars="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789".toCharArray();

    public static String getSalt(int n){
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new SecureRandom().nextInt(chars.length)];
            stringBuffer.append(aChar);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(6));
    }
}
