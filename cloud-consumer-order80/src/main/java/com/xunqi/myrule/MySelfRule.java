package com.xunqi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡规则类
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-05 15:11
 **/

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //定义为随机
        return new RandomRule();
    }

}
