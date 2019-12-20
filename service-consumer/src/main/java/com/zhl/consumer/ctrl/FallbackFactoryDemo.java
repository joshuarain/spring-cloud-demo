package com.zhl.consumer.ctrl;

import com.zhl.consumer.service.FeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 * @title: FallbackFactoryDemo
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/10 8:26
 */
@Component
public class FallbackFactoryDemo implements FallbackFactory<FeignService> {

    @Override
    public FeignService create(Throwable throwable) {
        FeignService feignService = str -> "fallbackFactory";
        return feignService;
    }
}

