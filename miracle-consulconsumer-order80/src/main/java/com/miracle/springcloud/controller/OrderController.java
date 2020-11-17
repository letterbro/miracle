package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zjm
 * @Date 2020/11/17
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    RestTemplate restTemplate;

    private final static String PAYMENT8006URL = "http://miracle-payment-service";

    @RequestMapping("/test01")
    public CommonResult ConsulTest() {
        return restTemplate.postForObject(PAYMENT8006URL + "/consultest", null, CommonResult.class);
    }
}
