package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author zjm
 * @Date 2020/11/16
 * @Description
 */

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String sp;

    @PostMapping("/zkTest")
    public CommonResult zkTest() {
        return new CommonResult(200, String.format("获取成功，端口号:%s，生成的UUID:%s", sp, UUID.randomUUID()));
    }

}
