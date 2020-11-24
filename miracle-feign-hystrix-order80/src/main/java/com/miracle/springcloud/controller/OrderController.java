package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import com.miracle.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author zjm
 * @Date 2020/11/19
 * @Description
 */
@Controller
@RestController
public class OrderController {

    @Resource
    OrderService os;

    @PostMapping("/order/hok")
    public CommonResult<String> hystrixTest_OK() {
        return os.hystrixTest_OK();
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @PostMapping("/order/hrandom")
    public CommonResult<String> hystrixTest_RANDOM(@RequestBody Payment p) {
        System.out.println(p);
        return os.hystrixTest_RANDOM(p);
    }

    //
//    public CommonResult<String> hystrixTest_RANDOMHandler(@RequestBody Payment p) {
//        return new CommonResult<>(444, "sorry, call failed!");
//    }
    @PostMapping("/order/hrandoms")
    public CommonResult<String> hystrixTest_RANDOM(@RequestBody String s) {
        System.out.println(s);
        return os.hystrixTest_RANDOMS(s);
    }

//    @HystrixCommand
//    @GetMapping("/order/foo/{foobar}")
//    public CommonResult<String> foo(@PathVariable(value = "foobar") String s) {
//        System.out.printf("s = > %s%n", s);
//        return os.foo(s);
//    }
//    public CommonResult<String> globalFallback() {
//        return new CommonResult<>(444,"全局服务降级处理");
//    }

}
