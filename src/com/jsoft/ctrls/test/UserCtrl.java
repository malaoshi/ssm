package com.jsoft.ctrls.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.model.UserModel;
import com.jsoft.services.UserSrv;
import com.jsoft.util.RequestTool;
import com.jsoft.util.TurnPage;

@Controller
@RequestMapping("/user")
public class UserCtrl {
	
	@Resource(name="userSrv")
	private UserSrv userSrv;

	@RequestMapping("/add")
	public ModelAndView add(UserModel um){
		ModelAndView mv=new ModelAndView();
		try {
			userSrv.insertUser(um);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("success");
		return mv;
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req){
		Map paraMap=RequestTool.getParameterMap(req);
		try {
			userSrv.updateUser(paraMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	@RequestMapping("deleteById")
	public ModelAndView deleteById(HttpServletRequest req){
		String id=req.getParameter("id");
		try {
			userSrv.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	@RequestMapping("deleteByIds")
	public ModelAndView deleteByIds(HttpServletRequest req){
		String[] idArray=req.getParameterValues("id");
		try {
			userSrv.deleteByIds(idArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("success");
		return mv;
	}
	
	@RequestMapping("queryList")
	public ModelAndView queryList(){
		ModelAndView mv=new ModelAndView();
		
		try {
			List list=userSrv.queryList();
			mv.addObject("ls", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("test/queryList");
		return mv;
	}
	
	@RequestMapping("queryList2")
	public ModelAndView queryList2(HttpServletRequest req){
		Map paraMap=RequestTool.getParameterMap(req);
		
		ModelAndView mv=new ModelAndView();
		
		try {
			List list=userSrv.queryList2(paraMap);
			mv.addObject("ls", list);
			mv.addObject("name", paraMap.get("name"));
			mv.addObject("pwd", paraMap.get("pwd"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("test/queryList2");
		return mv;
	}
	
	@RequestMapping("queryList3")
	public ModelAndView queryList3(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("test/queryList3");
		Map map=RequestTool.getParameterMap(req);
		map.put("turnPage", turnPage);//将turnPage放入map中，目的是向service传递数据
		
		try {
			List list=userSrv.queryList3(map);
			mv.addObject("name", map.get("name"));
			mv.addObject("pwd", map.get("pwd"));
			mv.addObject("ls", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
}
