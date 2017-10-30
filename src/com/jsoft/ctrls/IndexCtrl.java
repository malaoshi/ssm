package com.jsoft.ctrls;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.services.ChannelSrv;
import com.jsoft.services.InfoSrv;
import com.jsoft.util.MakeStaticPage;
import com.jsoft.util.PathTools;
import com.jsoft.util.RequestTool;
import com.jsoft.util.TurnPage;
import com.jsoft.util.UrlKit;

@Controller
@RequestMapping("/")
public class IndexCtrl {

	@Resource(name="channelSrv")
	private ChannelSrv channelSrv;
	
	@Resource(name="infoSrv")
	private InfoSrv infoSrv;
	
	@RequestMapping("/channel")
	public ModelAndView channel(HttpServletRequest req) throws Exception{
		
		ModelAndView mv=new ModelAndView();
		Map map=RequestTool.getParameterMap(req);
		
		List list=channelSrv.query(map);
		mv.addObject("list", list);
		mv.setViewName("head");
		return mv;
	}
	
	
	/*
	 * �����������ƣ���turnPage�����г�Ա����ͬ����������set����
	 * ��ô�ͽ���ֵ��ֵ����turnPage����ĳ�Ա������
	 */
	@RequestMapping("/list")
	public ModelAndView list(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest req) throws Exception{
		
		ModelAndView mv=new ModelAndView();
		Map map=RequestTool.getParameterMap(req);
		map.put("turnPage", turnPage);
//		if(map.get("title")==null){
//			map.put("title", "");
//		}
		List list=infoSrv.query(map);
		mv.addObject("list", list);
		mv.addObject("title", map.get("title"));
		mv.setViewName("list");
		return mv;
	}
	@RequestMapping("makeHtml")
	public void makeHtml(HttpServletRequest req,HttpServletResponse resp){
		File webRootFile=PathTools.getWebRootPath();//���ص���webroot�ĸ�Ŀ¼
		File indexHtml=new File(webRootFile,"index.html");//ƴװindex.html��·��
		if(indexHtml.exists()){//�ж��ļ��Ƿ����
			indexHtml.delete();//ɾ��
		}
		//
		String url=UrlKit.getURL(req);//���ص���վ��url��ַ��ͨ������ƴװ�ģ�Ϊ��ͨ��
		System.out.println("url==="+url);
		String path=indexHtml.getAbsolutePath();
		System.out.println("path==="+path);
		
		resp.setContentType( "text/html;charset=UTF-8 ");
		try {
			MakeStaticPage.makeHtml(url, path, "UTF-8");
			resp.getWriter().println("���ɾ�̬ҳ��ɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				resp.getWriter().println("���ɾ�̬ҳ��ʧ�ܣ�");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
