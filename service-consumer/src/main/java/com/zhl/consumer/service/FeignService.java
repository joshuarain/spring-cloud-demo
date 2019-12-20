package com.zhl.consumer.service;

import com.zhl.consumer.ctrl.FallbackCtrl;
import com.zhl.consumer.ctrl.FallbackFactoryDemo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Lenovo
 * @title: FeignService
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/9 16:35
 */
@FeignClient(value = "ServiceProvider",fallbackFactory = FallbackFactoryDemo.class,fallback = FallbackCtrl.class)
public interface FeignService {
    @GetMapping("test")
    String feignTest(String str) throws Exception;
}
