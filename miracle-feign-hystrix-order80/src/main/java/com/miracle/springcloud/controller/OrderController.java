package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/order/hrandom")
    public CommonResult<String> hystrixTest_RANDOM(String s) {
        System.out.println(s);
        return os.hystrixTest_RANDOM(s);
    }
}
