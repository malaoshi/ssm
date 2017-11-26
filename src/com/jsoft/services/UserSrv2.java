package com.jsoft.services;

import com.jsoft.Constant;
import com.jsoft.dao.DaoSupport;
import com.jsoft.pojo.User;
import com.jsoft.pojo.User2;
import com.jsoft.util.HanyuPinyinHelper;
import com.jsoft.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("UserSrv2")
public class UserSrv2 {

    @Resource(name="daoSupport")
    private DaoSupport dao;

    public Map save(Map map) throws Exception{
        String uuid= UUID.randomUUID().toString().replace("-","");
        String username=(String)map.get("username");
        String password=(String)map.get("password");

        String usernamePinyin=HanyuPinyinHelper.getFirstLettersUp(username);

        map.put("password",pwdMd5(password));
        map.put("id",uuid);
        map.put("pinyin",usernamePinyin);
        int i=dao.save("userMapper2.save",map);
        Map reMap=new HashMap();
        reMap.put("code",1);
        return reMap;
    }

    public Map executLogin(Map map) throws Exception{
        String username=(String)map.get("username");
        String password=(String)map.get("password");//表单原密码
        String passwordMD5=MD5Util.MD5(password+ Constant.MD5_CONSTANT);//md5加密后的表单密码
        List list=(List)dao.findList("userMapper2.login",username);
        Map reMap=new HashMap();
        if(list==null || list.isEmpty()){
            reMap.put("code",-1);
            reMap.put("msg","无此用户");
        }else{
            Map userMap=(Map)list.get(0);
            String passwordDb=(String)userMap.get("password");//数据库密码（md5加密过）
            if(passwordMD5.equals(passwordDb)){
                reMap.put("code",1);
            }else{
                reMap.put("code",-10);
                reMap.put("msg","密码错误！");
            }
        }

        return reMap;
    }

    public List showUserList(Map map) throws Exception{
        String uname=(String)map.get("uname");
//        String pinyin=HanyuPinyinHelper.getFirstLettersUp(uname);
//        map.put("py",pinyin);
//        uname="%"+uname+"%";
//        map.put("uname",uname);

        List list=dao.findList("userMapper2.find",map);
        return list;
    }

    public int deleteById(String userId) throws Exception{
        return dao.delete("userMapper2.deleteById",userId);
    }

    public int deleteByIds(String userIds) throws Exception{
        int i=0;
        if(userIds!=null && !"".equals(userIds)){
            String first=userIds.substring(0,1);
            String end=userIds.substring(userIds.length()-1);
            String newUserIds=userIds;
            if(",".equals(first)){
                newUserIds=newUserIds.substring(1);
            }
            if(",".equals(end)){
                newUserIds=newUserIds.substring(0,newUserIds.length()-1);
            }
            String[] array=newUserIds.split(",");
            i=dao.delete("userMapper2.deleteByIds",array);
        }
//        return dao.delete("userMapper2.deleteById",userId);

        return i;
    }

    public User2 showUserById(String id) throws  Exception{
        User2 u=(User2)dao.findOne("userMapper2.showUserById",id);
        return u;
    }

    public int updateById(Map map) throws Exception {
        return dao.update("userMapper2.modifyById",map);
    }

    public String pwdMd5(String pwd){
        String passwordMD5=MD5Util.MD5(pwd+ Constant.MD5_CONSTANT);//加盐
        return passwordMD5;
    }

    public int updatePwd(String userId) throws Exception{
        Map paraMap=new HashMap();
        paraMap.put("id",userId);
        paraMap.put("pwd",pwdMd5("123456"));
        return dao.update("userMapper2.modifyById",paraMap);

    }
}
