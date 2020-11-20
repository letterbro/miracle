package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import com.miracle.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * @Author zjm
 * @Date 2020/11/12
 * @Description
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
        int age = 10 / 0;
        if (null == payment || (!StringUtils.hasText(payment.getSerial()))) {
            return new CommonResult(444, "插入失败" + port);
        }
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入成功" + port);
        } else {
            return new CommonResult(444, "插入失败" + port);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentByIdTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        int time = (int) (Math.random() * 10);
        try {
            Thread.sleep(5000);
        } catch (Exception ignored) {
        }
        Payment result = paymentService.getPaymentById(id);
        if (null != result) {
            log.info("查询结果：result = " + result.toString());
            return new CommonResult<Payment>(200, "查询成功" + port, result);
        } else {
            return new CommonResult<Payment>(444, "查询失败" + port);
        }
    }

    public CommonResult<Payment> getPaymentByIdTimeOutHandler(Long id) {
        return new CommonResult<Payment>(444, "查询失败,Hystrix" + port);
    }

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/discovery")
    public CommonResult getDiscovery() {
        List<String> services = discoveryClient.getServices();
        return new CommonResult(200, "获取成功！", services);
    }


    @PostMapping(value = "/payment/instance")
    public CommonResult getInstance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("MIRACLE-PAYMENT-SERVICE");
        return new CommonResult(200, "获取成功", instances);

    }


}
