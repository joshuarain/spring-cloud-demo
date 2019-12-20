package com.zhl.consumer.ctrl;

import com.zhl.consumer.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Lenovo
 * @title: FeignClientCtrl
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/9 16:35
 */
@RestController
@Slf4j
public class FeignClientCtrl {

    @Value("${server.port}")
    private String port;

    @Resource
    private FeignService feignService;

    @GetMapping("test")
    public String test(String str) throws Exception {
        log.info("consumer test request,processing by port:{}", port);
        return feignService.feignTest(str);
    }


}
