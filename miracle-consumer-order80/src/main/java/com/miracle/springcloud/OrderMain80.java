package com.miracle.springcloud;

import com.miracle.myrule.MyRandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author zjm
 * @Date 2020/11/12
 * @Description
 */

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "MIRACLE-PAYMENT-SERVICE", configuration = MyRandomRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
