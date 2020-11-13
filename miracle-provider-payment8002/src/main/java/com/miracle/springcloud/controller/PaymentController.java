package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import com.miracle.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment) {
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
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (null != result) {
            log.info("查询结果：result = " + result.toString());
            return new CommonResult<Payment>(200, "查询成功" + port, result);
        } else {
            return new CommonResult<Payment>(444, "查询失败" + port);
        }
    }


}
