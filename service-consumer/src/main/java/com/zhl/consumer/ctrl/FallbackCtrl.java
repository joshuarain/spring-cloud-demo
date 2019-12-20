package com.zhl.consumer.ctrl;

import com.zhl.consumer.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 * @title: FallbackCtrl
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/9 17:09
 */
@Component
public class FallbackCtrl implements FeignService {

    @Override
    public String feignTest(String str) throws Exception {
        return "fallback";
    }
}
