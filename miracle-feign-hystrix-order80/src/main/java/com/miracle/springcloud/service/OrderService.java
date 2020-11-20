package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author zjm
 * @Date 2020/11/19
 * @Description
 */
@Component
@FeignClient(value = "MIRACLE-HYSTRIX-PAYMENT-SERVICE")
public interface OrderService {
    @PostMapping("/payment/hok")
    public CommonResult<String> hystrixTest_OK();
    @PostMapping("/payment/hrandom")
    public CommonResult<String> hystrixTest_RANDOM(String s);
}
