package com.jsoft.services;

import com.jsoft.dao.DaoSupport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("TestTransaction")
public class TestTransaction {
    @Resource(name = "daoSupport")
    private DaoSupport dao;
    public void execute() throws  Exception{
        Map map=new HashMap();
        map.put("id","11");
        map.put("username","哈哈");
        map.put("password","123");
        map.put("level","1");
        dao.save("userMapper2.save",map);

        Map map2=new HashMap();
        map2.put("id","12");
        map2.put("username","哈哈哈哈哈哈哈哈哈哈");
        map2.put("password","123");
        map2.put("level","2");
        dao.save("userMapper2.save",map2);
    }
}
