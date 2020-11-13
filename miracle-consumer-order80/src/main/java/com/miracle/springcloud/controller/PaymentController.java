package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @Author zjm
 * @Date 2020/11/12
 * @Description
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private RestTemplate restTemplate;

    final String PAYMENT_URL = "http://MIRACLE-PAYMENT-SERVICE";

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @PostMapping("/consumer/payment/instance")
    public CommonResult getInstance(@RequestBody Object object) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/instance", object, CommonResult.class);
    }

    @PostMapping("/consumer/payment/discovery")
    public CommonResult getDiscovery(@RequestBody Object object) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/discovery", object, CommonResult.class);
    }


}
