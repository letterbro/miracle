package com.miracle.springcloud.controller;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import com.miracle.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


    @PostMapping(value = "/ms/swipers")
    public CommonResult getSwipers(@RequestBody Map haha) {
        List<Swiper> swipers = new ArrayList<>();
        swipers.add(new Swiper("1", "img1", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2877325553,560783714&fm=26&gp=0.jpg"));
        swipers.add(new Swiper("2", "img2", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607075406250&di=2f4d41c77038acc6a490dd859440c8a2&imgtype=0&src=http%3A%2F%2Fpic3.16pic.com%2F00%2F53%2F22%2F16pic_5322554_b.jpg"));
        swipers.add(new Swiper("3", "img3", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607075406249&di=1442fb62146d5843ac351023221479b9&imgtype=0&src=http%3A%2F%2Fpic.90sjimg.com%2Fdesign%2F01%2F37%2F18%2F82%2Fs_1024_f0c29b9289ee968b02b7a417081d5a55.jpg"));
        return new CommonResult(200, "获取轮播图数据成功", swipers);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Swiper {
        private String id;
        private String img;
        private String url;
    }
}
