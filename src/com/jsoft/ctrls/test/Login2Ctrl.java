package com.jsoft.ctrls.test;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jsoft.model.UserModel;

@Controller
@RequestMapping("/login")
public class Login2Ctrl {
	int i=new Random().nextInt();
	/*
	 * 只响应get请求
	 */
	@RequestMapping(value="doLogin",method=RequestMethod.GET)
	public String doLogin(){
		System.out.println("i="+i);
		return "success";
	}
	@RequestMapping("doLogin2")
	public String doLogin2(String username,String password){
		System.out.println("username="+username);
		System.out.println("password="+password);
		return "success";
	}
	@RequestMapping("doLogin3")
	public String doLogin3(HttpServletRequest req,HttpServletResponse resp){
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		

		System.out.println("username="+username);
		System.out.println("password="+password);
		
		return "success";
	}
	@RequestMapping("doLogin4")
	public String doLogin4(UserModel um){
		System.out.println("username="+um.getUsername());
		System.out.println("password="+um.getPassword());
		return "success";
	}
	
	@RequestMapping("doLogin5")
	public String doLogin5(@ModelAttribute("user") UserModel um){
		System.out.println("username="+um.getUsername());
		System.out.println("password="+um.getPassword());
		
//		request.setattribute("user",um);
		return "success";
	}
	
	/*
	 * @RequestParam("username")中的username必须与表单控件名一致
	 * 
	 * 表单中必须有名字为username的控件，否则会报错
	 * 如果不想报错，需要设置required=false
	 */
	@RequestMapping("doLogin6")
	public String doLogin6(@RequestParam(value="username",required=false) String name){
		System.out.println("username="+name);
		
		return "success";
	}
	
	@RequestMapping("/doLogin7")
	public ModelAndView doLogin(UserModel um,RedirectAttributes ra){
		ModelAndView mv=new ModelAndView();
		if(!"admin".equals(um.getUsername())){
			mv.setViewName("redirect:/loginError.jsp");
			//浏览器端跳转，拼装数据
			ra.addAttribute("code", -100);//传汉字，但一般传递code值，负数表示各种错误，1表示正确
		}else if(!"123456".equals(um.getPassword())){
			mv.setViewName("redirect:/loginError.jsp");
			ra.addAttribute("code", -101);
		}else{
			mv.setViewName("success");
			mv.addObject("username", um.getUsername());//服务器端跳转，传递数据
		}
		
		return mv;
	}
}
