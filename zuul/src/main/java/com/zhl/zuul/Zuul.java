package com.zhl.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Lenovo
 * @title: Zuul
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/16 15:03
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul {
    public static void main(String[] args) {
        SpringApplication.run(Zuul.class,args);
    }
}
