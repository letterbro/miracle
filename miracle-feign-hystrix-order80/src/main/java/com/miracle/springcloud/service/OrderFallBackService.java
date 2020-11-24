package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.CommonResult;
import com.miracle.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author zjm
 * @Date 2020/11/24
 * @Description
 */
@Component
public class OrderFallBackService implements OrderService{
    @Override
    public CommonResult<String> hystrixTest_OK() {
        return new CommonResult<>(200,"hystrix hystrixTest_OK 降级");
    }

    @Override
    public CommonResult<String> hystrixTest_RANDOM(Payment p) {
        return new CommonResult<>(200,"hystrix hystrixTest_RANDOM 降级");
    }

    @Override
    public CommonResult<String> hystrixTest_RANDOMS(String s) {
        return new CommonResult<>(200,"hystrix hystrixTest_RANDOMS 降级");
    }

    @Override
    public CommonResult<String> foo(String s) {
        return new CommonResult<>(200,"hystrix foo 降级");
    }
}
