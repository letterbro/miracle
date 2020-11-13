package com.miracle.springcloud.service.Impl;

import com.miracle.springcloud.dao.PaymentDao;
import com.miracle.springcloud.entity.Payment;
import com.miracle.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zjm
 * @Date 2020/11/12
 * @Description
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
