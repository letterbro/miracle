package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author zjm
 * @Date 2020/11/19
 * @Description
 */
@Component
@FeignClient(value = "MIRACLE-HYSTRIX-PAYMENT-SERVICE",fallback = OrderFallBackService.class)
public interface OrderService {
    @PostMapping("/payment/hok")
    public CommonResult<String> hystrixTest_OK();

    @PostMapping("/payment/hrandom")
    public CommonResult<String> hystrixTest_RANDOM(@RequestBody Payment p);

    @PostMapping("/payment/hrandoms")
    public CommonResult<String> hystrixTest_RANDOMS(@RequestBody String s);

    @GetMapping("/payment/foo/{foobar}")
    public CommonResult<String> foo(@PathVariable(value = "foobar") String s) ;
}
