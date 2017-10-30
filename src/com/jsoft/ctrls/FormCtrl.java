package com.jsoft.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.model.UserModel;

@Controller
@RequestMapping(value="form")
public class FormCtrl {
	@RequestMapping(value="test",method=RequestMethod.GET)
	public String test(){
		System.out.println("1");
		return "formResult";
	}
	@RequestMapping(value="test2")
	public String test2(String username,String password,String gender){
		System.out.println("username="+username);
		System.out.println("password="+password);
		System.out.println("gender="+gender);
		return "formResult";
	}
	
	@RequestMapping(value="test3")
	public String test3(UserModel um){
		System.out.println("username="+um.getUsername());
		System.out.println("password="+um.getPassword());
		return "formResult";
	}
	
	@RequestMapping(value="test4")
	public String test4(@ModelAttribute("um") UserModel um){
		System.out.println("username="+um.getUsername());
		System.out.println("password="+um.getPassword());
		return "formResult";
	}
	
	@RequestMapping(value="test5")
	public String test5(@RequestParam(value="username",required=false)String name,@RequestParam(value="password")String pwd,String gender){
		System.out.println("username="+name);
		System.out.println("password="+pwd);
		System.out.println("gender="+gender);
		return "formResult";
	}
}
