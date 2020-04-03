package com.xunqi.springcloud.service;

import com.xunqi.springcloud.entities.Payment;

/**
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-03 21:14
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
