package com.stargazer.thrift.demo.server;

import com.stargazer.thrift.demo.server.service.RPCThriftServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServerApplication {
    private static RPCThriftServer rpcThriftServer;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        rpcThriftServer = context.getBean(RPCThriftServer.class);
        rpcThriftServer.start();
    }

}
