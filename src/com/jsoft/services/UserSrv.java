package com.jsoft.services;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsoft.KEY;
import com.jsoft.dao.DaoSupport;
import com.jsoft.model.UserModel;
import com.jsoft.util.MD5Util;
import com.jsoft.util.TurnPage;

@Service("userSrv")
public class UserSrv {

	@Resource(name="daoSupport")
	private DaoSupport dao;
	
	public void insertUser(UserModel um) throws Exception{
		System.out.println("username="+um.getUsername());
		um.setId(UUID.randomUUID().toString().replace("-", ""));
		
		String password=um.getPassword();
		String pwdMD5=MD5Util.MD5(password+KEY.PASSWORD_SUFFIX);
		um.setPassword(pwdMD5);
		
		/*
		 * 第一个参数：namespace.id
		 * 第二个参数：向sql传递的数据
		 */
		int i=dao.save("userMapper2.saveUser", um);
		System.out.println("i="+i);
	}
	
	public void updateUser(Map map) throws Exception{
		
		String password=(String)map.get("password");
		if(password!=null && !"".equals(password)){
			String pwdMD5=MD5Util.MD5(password+KEY.PASSWORD_SUFFIX);
			map.put("password",pwdMD5);
		}
		int i=dao.update("userMapper2.updateUser", map);
		System.out.println("影响了："+i+"条记录");
	}
	
	
	public void deleteById(String id) throws Exception{
		int i=dao.delete("userMapper2.deleteById", id);
		System.out.println("影响了："+i+"条记录");
	}
	
	public void deleteByIds(String[] idArray) throws Exception{
		int i=dao.delete("userMapper2.deleteByIds", idArray);
		System.out.println("影响了："+i+"条记录");
	}
	
	public List queryList() throws Exception{
		
		List list=dao.findList("userMapper2.queryList", null);
		
		return list;
	}
	public List queryList2(Map map) throws Exception{
		
		List list=dao.findList("userMapper2.queryList2", map);
		
		return list;
	}
	
	public List queryList3(Map map) throws Exception{
		TurnPage turnPage=(TurnPage)map.get("turnPage");
		/*
		 * 第一次查询，查询具体结果
		 */
		List list=dao.findList("userMapper2.queryList3", map);
		/*
		 * 第二次查询，只查询符合该条件的记录数
		 * 
		 */
		int obj=(Integer)dao.findOne("userMapper2.selectCount", map);
		turnPage.setTotal(obj);
		
		
		return list;
	}
}
