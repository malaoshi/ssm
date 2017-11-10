package com.jsoft.ctrls;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsoft.KEY;
import com.jsoft.services.LoginSrv;
import com.jsoft.util.MD5Util;


@Controller
@RequestMapping("/login")
public class LoginCtrl {

	@Resource(name="LoginSrv")
	private LoginSrv loginSrv;

	private String name;
	
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(HttpServletRequest req,HttpServletResponse resp,RedirectAttributes ra){
		ModelAndView mv=new ModelAndView();
		
		String username   =   req.getParameter("username");
		String password   =   req.getParameter("password");
		String passwordMD5=MD5Util.MD5(password+KEY.PASSWORD_SUFFIX);
		try {
			Map resultMap=loginSrv.doLogin(username, password);
			int code=(Integer)resultMap.get("code");
			if(code==1){
				Map userInfoMap=(Map)resultMap.get("userInfo");
				HttpSession session=req.getSession();
				session.setAttribute("userInfo", userInfoMap);
				mv.setViewName("mgr/index");
			}else{
				mv.setViewName("login");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("ajaxLogin")
	public Map ajaxLogin(HttpServletRequest req){
		Map map =new HashMap();
		
		String username   =   req.getParameter("username");
		String password   =   req.getParameter("password");
		String passwordMD5=MD5Util.MD5(password+KEY.PASSWORD_SUFFIX);
		try {
			Map resultMap=loginSrv.doLogin(username, password);
			int code=(Integer)resultMap.get("code");
			if(code==1){
				Map userInfoMap=(Map)resultMap.get("userInfo");
				HttpSession session=req.getSession();
				session.setAttribute("userInfo", userInfoMap);
			}
			map.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
