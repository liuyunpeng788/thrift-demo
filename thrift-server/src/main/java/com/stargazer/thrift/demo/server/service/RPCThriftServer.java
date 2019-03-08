package com.stargazer.thrift.demo.server.service;

import com.stargazer.thrift.api.service.RpcDateThriftService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RPCThriftServer {
    @Value("${thrift.port}")
    private int port;

    @Value("${thrift.minWorkerThreads}")
    private int minThreads;

    @Value("${thrift.maxWorkerThreads}")
    private int maxThreads;

    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;

    @Autowired
    private RpcDateServiceImpl rpcDateService;

    public void init(){
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    public void start(){
        RpcDateThriftService.Processor processor = new RpcDateThriftService.Processor<RpcDateThriftService.Iface>(rpcDateService);
        init();
        try{
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            TServer server = new TThreadPoolServer(tArgs);
            server.serve();
        }catch (Exception ex){
            System.out.println("thrift server start failure. " + ex.getLocalizedMessage());
        }

    }
}
