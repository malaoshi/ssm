package com.jsoft.ctrls;

import com.jsoft.services.LoginSrv2;
import com.jsoft.util.RequestTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login2")
public class LoginCtrl2 {

    @Resource(name = "LoginService2")
    private LoginSrv2 login;

    @RequestMapping("/doLogin")
    public ModelAndView doLogin(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        Map reMap=login.executLogin(username,password);
        int code=(int)reMap.get("code");
        ModelAndView mv=new ModelAndView();
        if(code==1){
            mv.setViewName("success");
            mv.addObject("uname",username);
        }
        return mv;
    }
    @ResponseBody
    @RequestMapping("ajax")
    public Map doLogin2(HttpServletRequest request){
        Map map= RequestTool.getParameterMap(request);
//        if()

        Map result=new HashMap();
        result.put("code",-100);
        result.put("msg","用户名或密码错误！");
        return result;

    }

    @RequestMapping("red")
    public String red(RedirectAttributes ra){
        ra.addAttribute("code",1);
        return "redirect:/test2.jsp";
    }
}
