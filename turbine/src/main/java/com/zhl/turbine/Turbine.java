package com.zhl.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author Lenovo
 * @title: Turbine
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/12 11:13
 */
@SpringBootApplication
@EnableTurbine
public class Turbine {
    public static void main(String[] args) {
        SpringApplication.run(Turbine.class,args);
    }
}
