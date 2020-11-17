package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author zjm
 * @Date 2020/11/17
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @PostMapping("/consultest")
    public CommonResult testPaymentService() {
        boolean flag = Math.random() >= 0.5;
        return new CommonResult(flag ? 200 : 444, flag ? "这次调用成功了，你是一只幸运猪！随机数："
                + Math.random() : "你好，佩奇，我是你的爸爸乔治,调用成功但是返回失败了！随机数"
                + Math.random());
    }
}
