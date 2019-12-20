package com.zhl.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lenovo
 * @title: RibbonRestTemplate
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/10 8:53
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix //不加可以熔断
public class RibbonRestTemplate {
    public static void main(String[] args) {
        SpringApplication.run(RibbonRestTemplate.class,args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
