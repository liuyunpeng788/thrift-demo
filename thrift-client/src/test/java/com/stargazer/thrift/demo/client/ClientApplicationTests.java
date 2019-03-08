package com.stargazer.thrift.demo.client;

import com.stargazer.thrift.demo.client.controller.RPCThriftController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

    @Test
    public void contextLoads() {

    }
    @Autowired
    RPCThriftController controller;
    @Test
    public void testSendMsg(){
        String msg = "max1";
        controller.thriftTest();
    }

}
