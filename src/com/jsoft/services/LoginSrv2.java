package com.jsoft.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("LoginService2")
public class LoginSrv2 {


    public Map executLogin(String username,String password){

        Map reMap=new HashMap();
        reMap.put("code",1);

        return reMap;
    }
}
