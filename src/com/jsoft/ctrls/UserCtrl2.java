package com.jsoft.ctrls;

import com.jsoft.pojo.User2;
import com.jsoft.services.UserSrv2;
import com.jsoft.util.RequestTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user2")
public class UserCtrl2 {
    @Resource(name = "UserSrv2")
    private UserSrv2 service;

    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        Map map= RequestTool.getParameterMap(request);

        try {
            Map reMap = service.save(map);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "success";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        Map map= RequestTool.getParameterMap(request);
        Map reMap=null;
        try {
            reMap=service.executLogin(map);
        }catch(Exception e){
            e.printStackTrace();
        }
        int code=(int)reMap.get("code");
        String msg=(String)reMap.get("msg");
        if(code==1){
            return "success";
        }else{
            request.setAttribute("msg",msg);
            return "fails";
        }
    }
    @RequestMapping("/showUserList")
    public ModelAndView showUserList(HttpServletRequest request){
        Map map=RequestTool.getParameterMap(request);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("user/showUserList");//服务端跳转
        try {
            List list=service.showUserList(map);
//            request.setAttribute("");
            mv.addObject("userList",list);
            mv.addObject("level",map.get("level"));
            mv.addObject("uname",map.get("uname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
    @RequestMapping("/deleteById")
    public String deleteById(HttpServletRequest request,String id){
        try {
            int i=service.deleteById(id);
            request.setAttribute("result",i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "deleteSuccess";
    }
    //返回json
    @ResponseBody
    @RequestMapping("/deleteByIds")
    public Object deleteByIds(String ids){
        int i=0;
        try {
            i=service.deleteByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map reMap=new HashMap();
        if(i>0){
            reMap.put("code",1);
        }else{
            reMap.put("code",0);
        }
        reMap.put("result",i);
        return reMap;
    }
    @RequestMapping("/showUserById")
    public String showUserById(HttpServletRequest request){
        String id=request.getParameter("id");
        try {
            User2 user2=(User2)service.showUserById(id);
            request.setAttribute("user",user2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "user/showUserById";
    }

    @RequestMapping("/modifyById")
    public ModelAndView modifyById(HttpServletRequest request){
        Map paraMap=RequestTool.getParameterMap(request);
        int i=0;
        try {
            i=service.updateById(paraMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("result",i);
        mv.setViewName("user/updateSuccess");
        return mv;
    }


    @ResponseBody
    @RequestMapping("/resetPwd")
    public Object resetPwd(String userId){
        int result=0;
        try {
            result=service.updatePwd(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map reMap=new HashMap();
        if(result>0){
            reMap.put("code",1);
        }else{
            reMap.put("code",0);
            reMap.put("msg","重置密码失败！");
        }
        return reMap;
    }
}
