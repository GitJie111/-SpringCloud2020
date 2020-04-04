package com.xunqi.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Created with IntelliJ IDEA.
 * @author: 夏沫止水
 * @create: 2020-04-03 22:02
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced       //需要使用@LoadBalanced注解开启RestTemplate负载均衡功能
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
