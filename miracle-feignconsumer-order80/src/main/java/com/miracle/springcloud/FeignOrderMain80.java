package com.miracle.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zjm
 * @Date 2020/11/18
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class, args);
    }
}
