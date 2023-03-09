package org.apache.dobbo.samples.client;

import java.io.IOException;

import org.apache.dobbo.samples.api.GettingService;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;


public class Application {
    public static void main(String[] args) throws IOException {
        ReferenceConfig<GettingService> reference = new ReferenceConfig<>();
        reference.setInterface(GettingService.class);

        DubboBootstrap.getInstance()
                .application("first-dubbo-consumer")
                .registry(new RegistryConfig("zookeeper://1.15.222.191:2181"))
//                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference);

        GettingService service = reference.get();
        String message = service.sayHi("12345");
        System.out.println("Receive result ======> " + message);
        System.in.read();
    }
}