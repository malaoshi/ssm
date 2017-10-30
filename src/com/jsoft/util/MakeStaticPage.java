package com.jsoft.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MakeStaticPage {
	//String saveRoute = new File(PathTools.getWebRootPath(),"/html/"+aid+".html").getAbsolutePath(); 鑾峰彇璺緞
	/*
	 * 通过java代码模拟发出http请求，将请求得到的内容生成html文件
	 */
	public static void makeHtml(String url, String filePath, String chartset) throws IOException {//page 璺緞 url锛宖ilePath 淇濆瓨璺緞锛宑harset 瀛楃闆?
		HttpURLConnection huc = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			huc = (HttpURLConnection) new URL(url).openConnection();
			huc.connect();
			InputStream stream = huc.getInputStream();
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath), chartset));
			br = new BufferedReader(new InputStreamReader(stream, chartset));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().length() > 0) {
					bw.write(line);
					bw.newLine();
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				br.close();
				bw.close();
				huc.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}   

}
