package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import com.miracle.springcloud.service.feignTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author zjm
 * @Date 2020/11/18
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private feignTestService feignTestService;

    @PostMapping("/feignTest")
    public CommonResult feignTest() {
        return feignTestService.zkTest();
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignTestService.getPaymentById(id);
    }
}
