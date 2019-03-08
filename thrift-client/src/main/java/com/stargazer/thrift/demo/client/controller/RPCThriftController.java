package com.stargazer.thrift.demo.client.controller;

import com.stargazer.thrift.demo.client.service.RPCThriftClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPCThriftController {
    @Autowired
    private RPCThriftClientService rpcThriftClientService;



    @RequestMapping("/thriftTest")
    public void thriftTest(){
        try{
            rpcThriftClientService.open();
            String msg = rpcThriftClientService.getRpcThriftService().getDate("max");
            System.out.println(msg);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            rpcThriftClientService.close();
        }

    }
}
