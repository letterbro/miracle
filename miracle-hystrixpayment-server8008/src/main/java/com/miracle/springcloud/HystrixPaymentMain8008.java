package com.miracle.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zjm
 * @Date 2020/11/19
 * @Description
 */

@SpringBootApplication
@EnableDiscoveryClient
public class HystrixPaymentMain8008 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8008.class, args);
    }
}
