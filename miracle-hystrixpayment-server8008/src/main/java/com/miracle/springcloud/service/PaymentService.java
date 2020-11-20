package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult<String> hystrixTest_RANDOM(@RequestBody Payment p) {
        if (Math.random() >= 0.5) {
            try {
                Thread.sleep(5 * 1000);
            } catch (Exception ignored) {

            }
        }
        System.out.println("i'am in" + t++);
        return new CommonResult<String>(200, String.format("恭喜你，调用成功，接收到的字符串为：%s, 线程池：name: %s, id: %s", p.toString(), Thread.currentThread().getName(), Thread.currentThread().getId()));
    }

    @PostMapping("/payment/hrandoms")
    public CommonResult<String> hystrixTest_RANDOMS(@RequestBody String s) {
        if (Math.random() >= 0.5) {
            try {
                Thread.sleep(5 * 1000);
            } catch (Exception ignored) {

            }
        }
        System.out.println("i'am in" + t++);
        return new CommonResult<String>(200, String.format("恭喜你，调用成功，接收到的字符串为：%s, 线程池：name: %s, id: %s", s, Thread.currentThread().getName(), Thread.currentThread().getId()));
    }

    @GetMapping("/payment/foo/{foobar}")
    public CommonResult<String> foo(@PathVariable(value = "foobar") String s) {
        if (Math.random() >= 0.5) {
            try {
                Thread.sleep(3 * 1000);
            } catch (Exception ignored) {

            }
        }
//        System.out.println("i'am in" + t++);
        System.out.println(String.format("\033[47m恭喜你，调用成功，接收到的字符串为：%s, 线程池：name: %s, id: %s\033[30m", s, Thread.currentThread().getName(), Thread.currentThread().getId()));
        return new CommonResult<String>(200, String.format("恭喜你，调用成功，接收到的字符串为：%s, 线程池：name: %s, id: %s\033[30m", s, Thread.currentThread().getName(), Thread.currentThread().getId()));
    }

}
