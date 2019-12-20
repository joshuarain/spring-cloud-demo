package com.zhl.ribbon.ctrl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lenovo
 * @title: RibbonCtrl
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/10 8:55
 */
@RestController
public class RibbonCtrl {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("test")
    @HystrixCommand(fallbackMethod = "getItemsFB")
    public String test(String str){
        Object result = restTemplate.getForEntity("http://ServiceProvider/test?str=1",String.class);

        return result.toString();
    }

    public String getItemsFB(String str){
        return "ribbonFallback";
    }
}
