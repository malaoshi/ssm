package com.jsoft.services;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsoft.dao.DaoSupport;
import com.jsoft.util.TurnPage;

@Service("infoSrv")
public class InfoSrv {

	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	
	
	public List query(Map map) throws Exception{
		TurnPage turnPage=(TurnPage)map.get("turnPage");
		List list=daoSupport.findList("infoMapper.select", map);//²éÑ¯Êý¾Ý
		int count=(Integer)daoSupport.findOne("infoMapper.select_count", map);
		turnPage.setTotal(count);
		return list;
	}
}
