package org.apache.dobbo.samples.provider;

import org.apache.dobbo.samples.api.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHi(String name) {
        return "hi" + name;
    }
}
