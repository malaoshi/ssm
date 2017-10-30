package com.jsoft.ctrls.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redirectCtrl")
public class RedirectCtrl {

	@RequestMapping("/test")
	public String test(){
		/*
		 * 服务器端跳转
		 * return "success";
		 */
		/*
		 * 重定向，客户端跳转
		 * 与视图解析器无关
		 * 传递数据？
		 */
		String msg="123";
		return "redirect:/mgr/test.jsp?code=1&msg="+msg;
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2(ModelAndView mv,RedirectAttributes ma){
		mv.setViewName("redirect:/mgr/test.jsp");
		ma.addAttribute("code", 1);
		ma.addAttribute("msg", "用户名错误");
		return mv;
	}
	
}
