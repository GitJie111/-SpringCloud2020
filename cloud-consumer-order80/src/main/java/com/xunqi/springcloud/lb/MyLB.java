package com.xunqi.springcloud.lb;
import	java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-05 18:51
 **/
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {

        Integer current;
        int next;
        //自旋锁
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********第几次访问：次数next:" + next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次请求 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后rest接口计数从1开始
     * @param serviceInstance
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {

        int index = getAndIncrement() % serviceInstance.size();

        return serviceInstance.get(index);
    }
}
