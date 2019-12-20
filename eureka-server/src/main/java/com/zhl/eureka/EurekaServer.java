package com.zhl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 * @title: EurekaServer
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/9 15:33
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }

    @GetMapping("error")
    public String error(){
        return "error";
    }


}
