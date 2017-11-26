package com.jsoft.ctrls;

import com.jsoft.services.TestTransaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/test")
public class TestCtrl {

    @Resource(name = "TestTransaction")
    private TestTransaction testTransaction;

    @RequestMapping("/transaction")
    public void transaction(){
        try {
            testTransaction.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
