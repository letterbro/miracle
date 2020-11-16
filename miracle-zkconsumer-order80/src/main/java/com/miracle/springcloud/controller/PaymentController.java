package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zjm
 * @Date 2020/11/16
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    RestTemplate restTemplate;
    private final String URL = "http://miracle-provider-payment";
    @PostMapping("/zkTest")
    public CommonResult getZkTest() {
        System.out.println("i'm here*******");
        return restTemplate.postForObject(URL + "/zkTest", null, CommonResult.class);
    }
}
