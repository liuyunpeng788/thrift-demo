package com.stargazer.thrift.demo.server.service;

import com.stargazer.thrift.api.service.RpcDateThriftService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class RpcDateServiceImpl implements RpcDateThriftService.Iface {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public String getDate(String userName) throws TException {
        LocalDateTime localDateTime = LocalDateTime.now();
        return "hello " + userName + ",now it is " + localDateTime.format(formatter);
    }
}
