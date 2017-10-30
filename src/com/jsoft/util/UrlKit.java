package com.jsoft.util;

import javax.servlet.http.HttpServletRequest;

public class UrlKit {

	/**
	 * 获取url，格式：http://ip:port/contextPath，如果port是80，不显示
	 * @param request
	 * @return
	 */
	public static String getURL(HttpServletRequest request){
		String basePath = request.getScheme()+"://"+request.getServerName();//http://
		String path = request.getContextPath();//返回的是上下文，一般情况下就是工程名
		int port=request.getServerPort();//端口
		if("/".equals(path)){
			path="";
		}
		if(port!=80){
			basePath=basePath+":"+port;
		}
		basePath=basePath+path;
//		String basePath2 = basePath;
//		basePath=basePath+"/";
		return basePath;
	}
	public static String getDomain(HttpServletRequest request){
		return getURL(request);
	}
	/**
	 * 结尾带斜杠
	 * @param request
	 * @return
	 */
	public static String getDomainSlash(HttpServletRequest request){
		return getURL2(request);
	}
	/**
	 * 获取url，格式：http://ip:port/contextPath/，如果port是80，不显示
	 * @param request
	 * @return
	 */
	public static String getURL2(HttpServletRequest request){
		return getURL(request)+"/";
	}
}
