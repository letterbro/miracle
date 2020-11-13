package com.miracle.springcloud.service;

import com.miracle.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Author zjm
 * @Date 2020/11/12
 * @Description
 */

@Service
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
