package com.miracle.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zjm
 * @Date 2020/11/16
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkConsumerMain80.class, args);
    }
}
