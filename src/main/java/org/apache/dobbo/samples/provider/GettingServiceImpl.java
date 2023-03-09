package org.apache.dobbo.samples.provider;

import org.apache.dobbo.samples.api.GettingService;

public class GettingServiceImpl implements GettingService {
    @Override
    public String sayHi(String name) {
        return "hi" + name;
    }
}
