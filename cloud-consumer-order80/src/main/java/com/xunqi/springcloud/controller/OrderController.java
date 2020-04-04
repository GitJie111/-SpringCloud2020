package com.xunqi.springcloud.controller;

import com.xunqi.springcloud.entities.CommonResult;
import com.xunqi.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-03 22:00
 **/
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @RequestMapping(value = "/order/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }

        //获得指定微服务的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVER");

        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
