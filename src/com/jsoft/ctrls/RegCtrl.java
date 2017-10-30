package com.jsoft.ctrls;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.KEY;
import com.jsoft.util.MD5Util;


@Controller
@RequestMapping("/reg")
public class RegCtrl {

	@ResponseBody
	@RequestMapping("/check")
	public Map check(HttpServletRequest req){
		String name=req.getParameter("name");
		/*
		 * 查询数据库判断用户是否存在，代码略
		 * 
		 */
		
		Map reMap=new HashMap();
		reMap.put("code", 1);//1:无此用户；2：有此用户
		
		return reMap;
	}
	@RequestMapping("doReg")
	public ModelAndView doReg(HttpServletRequest req){
		String password=req.getParameter("password");
		String passwordMD5=MD5Util.MD5(password+KEY.PASSWORD_SUFFIX);
		//E10ADC3949BA59ABBE56E057F20F883E
		//FCEA920F7412B5DA7BE0CF42B8C93759-----》425421F2D35F602FC3C289F1C53863C9-->F032B5C1F67233DD058108C77C468EEA
		return null;
	}
}
