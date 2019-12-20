package com.zhl.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 * @title: ServiceProvider
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/9 16:38
 */
@SpringBootApplication
@RestController
@Slf4j
public class ServiceProvider {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("test")
    public String feignTest(String str) throws Exception {
        log.info("处理端口：{}", port);
//        try {
        if (str.equals("1")) {
            throw new Exception("人为异常！");
        } else {
//        } catch (Exception e) {
//            System.out.println("provider sleep:" + e.getMessage());
//        }
            return "provider";
        }
    }

    public <T> T abc() {
        return null;
    }
}
