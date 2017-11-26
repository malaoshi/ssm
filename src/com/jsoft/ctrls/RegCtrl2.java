package com.jsoft.ctrls;

import com.jsoft.pojo.User;
import com.jsoft.util.RequestTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/reg2")
public class RegCtrl2 {
    @RequestMapping("/do")
    public ModelAndView reg(HttpServletRequest request){
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String gender=request.getParameter("gender");
        String[] likeArray=request.getParameterValues("like");
        String me=request.getParameter("me");

        ModelAndView mv=new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("password",password);
        mv.addObject("gender",gender);
        mv.addObject("likeArray",likeArray);
        mv.addObject("me",me);

        mv.setViewName("success3");

        return mv;
    }

    @RequestMapping("do2")
    public ModelAndView reg2(String username,String password){


        ModelAndView mv=new ModelAndView();
        mv.addObject("name",username);
        mv.addObject("password",password);
//        mv.addObject("gender",gender);
//        mv.addObject("likeArray",likeArray);
//        mv.addObject("me",me);

        mv.setViewName("success3");
        return mv;
    }

    @RequestMapping("do3")
    public ModelAndView reg3(@RequestParam(value = "username") String name,@RequestParam(value = "password",required = false) String pwd){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("success3");
        mv.addObject("name",name);
        mv.addObject("password",pwd);
//        mv.addObject("gender",gender);
//        mv.addObject("likeArray",likeArray);
//        mv.addObject("me",me);


        return mv;
    }

    @RequestMapping("do4")
    public ModelAndView reg4(User user){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("success4");
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("do5")
    public String reg5(HttpServletRequest request){
        Map map= RequestTool.getParameterMap(request);

        return "success4";
    }
    @RequestMapping("red")
    public String red(HttpServletRequest request,HttpServletResponse response){
//        request.setAttribute("name","吴亦凡");重定向无法传递这种方式的数据
//        try {
//
////            request.getRequestDispatcher("").forward(request,response);//跳转，转发，服务器跳转，地址栏不变
////            response.sendRedirect("");//跳转，重定向，浏览器端跳转，地址栏变
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        return "redirect:/success5.jsp?code=1&msg=12345";
    }
    @RequestMapping("red2")
    public String red2(RedirectAttributes ra){
        ra.addAttribute("code",1);
        ra.addAttribute("name","吴亦凡");
        return "redirect:/success5.jsp";
    }


}
