package com.jsoft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsoft.dao.DaoSupport;

@Service("LoginSrv")
public class LoginSrv {
	
	@Resource(name="daoSupport")
	private DaoSupport dao;
	
	public Map doLogin(String username,String password) throws Exception{
		Map reMap=new HashMap();
		
		List list=dao.findList("userMapper.selectByUsername", username);
		if(list!=null && !list.isEmpty()){
			Map map=(Map)list.get(0);
			String passwordDB=(String)map.get("password");
			if(password.equals(passwordDB)){
				reMap.put("code", 1);//
				reMap.put("userInfo", map);//
			}else{
				reMap.put("code", -2);//密码错误
			}
			
		}else{
			reMap.put("code", -1);//无此用户名
		}
		
		return reMap;
	}
	
}
