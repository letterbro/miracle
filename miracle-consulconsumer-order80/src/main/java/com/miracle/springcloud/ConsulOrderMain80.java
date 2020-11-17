package com.miracle.springcloud;

import com.miracle.myrule.MyRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author zjm
 * @Date 2020/11/17
 * @Description
 */
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "MIRACLE-PAYMENT-SERVICE",configuration = MyRandomRule.class)
public class ConsulOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain80.class, args);
    }
}
