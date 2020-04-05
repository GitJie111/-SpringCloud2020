package com.xunqi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义轮询算法
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-05 18:49
 **/
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstance);

}
