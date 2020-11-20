package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

/**
 * @Author zjm
 * @Date 2020/11/18
 * @Description
 */
@FeignClient(value = "MIRACLE-PAYMENT-SERVICE")
@Component
public interface feignTestService {
    @PostMapping("/zkTest")
    public CommonResult zkTest() ;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
