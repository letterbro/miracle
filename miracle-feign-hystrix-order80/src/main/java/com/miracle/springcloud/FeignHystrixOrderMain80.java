package com.miracle.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zjm
 * @Date 2020/11/19
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class FeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class, args);
    }
}
