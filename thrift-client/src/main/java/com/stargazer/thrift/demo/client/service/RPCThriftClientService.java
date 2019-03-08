package com.stargazer.thrift.demo.client.service;

import com.stargazer.thrift.api.service.RpcDateThriftService;
import lombok.Data;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class RPCThriftClientService {
    private RpcDateThriftService.Client client;
    private TBinaryProtocol protocol;
    private TSocket transport;
//    private String host;
//    private int port;

    @Value("${thrift.host}")
    private String host;
    @Value("${thrift.port}")
    private int port;

    public void init(){
        transport = new TSocket(host,port);
        protocol = new TBinaryProtocol(transport);
        client = new RpcDateThriftService.Client(protocol);
    }
    public void open() throws TTransportException{
        init();
        transport.open();
    }
    public RpcDateThriftService.Client getRpcThriftService(){
        return client;
    }

    public void close(){
        transport.close();
    }
}
