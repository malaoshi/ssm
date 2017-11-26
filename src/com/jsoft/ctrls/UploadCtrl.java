package com.jsoft.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/upload")
public class UploadCtrl {

    @RequestMapping("do")
    public String upload(@RequestParam(value = "head" )MultipartFile mf, HttpServletRequest request){
        //文件移动，从临时目录移动到指定的位置，改名
        String name=mf.getName();
        String orgName=mf.getOriginalFilename();
        System.out.println("name="+name);
        System.out.println("orgName="+orgName);
        /*
        生成File对象，要保存文件的路径+文件名
        1.找到路径。通过代码获取当前路径
        2.改名
         */
        String rootPath=request.getServletContext().getRealPath("/");
        File uploadFile=new File(rootPath,"upload");
        /*
        判断当前是否存在upload文件夹，如果不存在，就创建
         */
        if(!uploadFile.exists()){
            uploadFile.mkdirs();//mk:make
        }
        /*
        拼装文件名
         */
        File file=new File(uploadFile,orgName);
        try {
            mf.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        String username=request.getParameter("username");
        String imgUrl="/upload/"+orgName;//根目录
        request.setAttribute("imgUrl",imgUrl);
//        request.setAttribute("imgUrl",file.getAbsolutePath());
        return "showImg";//服务器端跳转
//        "redirect:/showImg.jsp"//浏览器端跳转
//        response.sendRedirect("");
    }
}
