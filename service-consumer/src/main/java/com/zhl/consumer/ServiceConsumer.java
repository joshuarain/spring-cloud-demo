package com.zhl.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lenovo
 * @title: ServiceConsumer
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/9 16:34
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class ServiceConsumer {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumer.class,args);
    }
}
