package com.stargazer.thrift.demo.client.config;

import com.stargazer.thrift.demo.client.service.RPCThriftClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;

@Deprecated
@Description("这个配置类的注入其实可以放在service成直接实现，它在这里这么写的原因，其实也就是希望在系统加载的时候执行相应初始化操作，因此，此处没有按照网上的案例直接写")
//@Configuration
public class RPCThriftClientConfig {
    @Value("${thrift.host}")
    private String host;
    @Value("${thrift.port}")
    private int port;

//    @Bean(initMethod = "init")
    public RPCThriftClientService rpcThriftClient(){
        RPCThriftClientService rpcThriftClientService = new RPCThriftClientService();
        rpcThriftClientService.setHost(host);
        rpcThriftClientService.setPort(port);
        return rpcThriftClientService;
    }
}
