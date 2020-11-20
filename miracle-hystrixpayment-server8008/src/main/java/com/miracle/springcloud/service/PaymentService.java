package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zjm
 * @Date 2020/11/19
 * @Description
 */
@Service
@RestController
public class PaymentService {

    @PostMapping("/payment/hok")
    public CommonResult<String> hystrixTest_OK() {
        return new CommonResult<>(200, String.format("线程池： %s ,this is HYSTRIXTEST_OK", Thread.currentThread().getName()));
    }

    static int t = 1;

    @PostMapping("/payment/hrandom")
    public CommonResult<String> hystrixTest_RANDOM(String s) {
        if (Math.random() >= 0.5) {
            try {
                Thread.sleep(5 * 1000);
            } catch (Exception ignored) {

            }
        }
        System.out.println("i'am in" + t++);
        return new CommonResult<String>(200, String.format("恭喜你，调用成功，接收到的字符串为：%s, 线程池：name: %s, id: %s", s, Thread.currentThread().getName(), Thread.currentThread().getId()));
    }

}
