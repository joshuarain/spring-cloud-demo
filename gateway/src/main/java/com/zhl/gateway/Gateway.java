package com.zhl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author Lenovo
 * @title: Gateway
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/16 16:39
 */
@SpringBootApplication
public class Gateway {
    public static void main(String[] args) {
        SpringApplication.run(Gateway.class, args);
    }
    // checkbug
    @Bean
    public RouteLocator route(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(
                r -> r.path("/ribbon-rest-template/**")
                        .filters(
                                f -> f.stripPrefix(1)
                        )
                        .uri("lb://RibbonRestTemplate")
                        .order(0)
                        .id("ribbon-rest-template")
        ).build();
    }
}
