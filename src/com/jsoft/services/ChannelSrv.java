package com.jsoft.services;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jsoft.dao.DaoSupport;
import com.jsoft.util.TurnPage;

@Service("channelSrv")
public class ChannelSrv {

	@Resource(name="daoSupport")
	private DaoSupport daoSupport;
	
	
	public List query(Map map) throws Exception{
		
		List list=daoSupport.findList("channelMapper.select", map);
		return list;
	}
}
