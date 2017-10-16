package com.lidan.customer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by danli on 2017/9/28.
 */
@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://SERVICE-TEST/add?a=10&b=20", String.class).getBody();
    }
    public String addServiceFallback() {
        return "error";
    }
}
