package com.jsoft.util;

import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5(String s) {
		return MD5(s,null);
	}
	public final static String MD5(String s,String characterEncoding) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = null;
            if(characterEncoding==null){
            	btInput=s.getBytes();
            }else{
            	btInput=s.getBytes(characterEncoding);
            }
            // 获得MD5摘要算法�?MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘�?
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	public static void main(String[] args){
		long s=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			System.out.println(MD5("123456"));
		}
		long e=System.currentTimeMillis();
		System.out.println(e-s);
	}
}
