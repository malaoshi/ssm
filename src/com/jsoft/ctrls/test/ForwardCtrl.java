package com.jsoft.ctrls.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsoft.model.UserModel;

/*
 * 服务器端跳转，转发
 * 可以向结果页面传递复杂数据，将数据放到request对象中
 */
@Controller
@RequestMapping("/forwardCtrl")
public class ForwardCtrl {

	@RequestMapping(value="/forward")
	public ModelAndView forward(ModelAndView mv,UserModel um){
		
		System.out.println("username:"+um.getUsername());
//		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("success2");
		mv.addObject("msg", "1阿斯顿老费劲按劳动法");//request.setAttribute();
		return mv;
	}
	
}
