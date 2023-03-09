package org.apache.dobbo.samples.provider;

import org.apache.dobbo.samples.api.GettingService;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;


public class Application {
    public static void main(String[] args) {
        // 定义具体的服务
        ServiceConfig<GettingService> service = new ServiceConfig<>();
        service.setInterface(GettingService.class);
        service.setRef(new GettingServiceImpl());

        // 启动 Dubbo
        DubboBootstrap.getInstance()
                .application("first-dubbo-provider")
                .registry(new RegistryConfig("zookeeper://1.15.222.191:2181"))
//                .registry(new RegistryConfig("zookeeper://1.15.222.191:2181"))
                .protocol(new ProtocolConfig("dubbo", -1))
                .service(service)
                .start()
                .await();
    }
}
