package com.zhl.consumer.ctrl;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;



/**
 * @author Lenovo
 * @title: ELKController
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/17 9:04
 */
@RestController
public class ELKController {
    private static final Logger LOG = Logger.getLogger(ELKController.class.getName());

    @Autowired
    RestTemplate restTemplete;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/elkdemo")
    public String helloWorld() {
        String response = "Hello user ! " + new Date();
        LOG.log(Level.INFO, "/elkdemo - > " + response);

        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String rsp = "";
        try {
            int i = 1 / 0;
            // should get exception
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String sStackTrace = sw.toString(); // stack trace as a string
            LOG.error("Exception As String :: - > "+sStackTrace);

            rsp = sStackTrace;
        }

        return rsp;
    }

    @RequestMapping(value = "/elk")
    public String helloWorld1() {

        String response = restTemplete.exchange("http://localhost:8763/elkdemo", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
        LOG.log(Level.INFO, "/elk - > " + response);

        try {
            String exceptionrsp = restTemplete.exchange("http://localhost:8763/exception", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
            }).getBody();
            LOG.log(Level.INFO, "/elk trying to print exception - > " + exceptionrsp);
            response = response + " === " + exceptionrsp;
        } catch (Exception e) {
            // exception should not reach here. Really bad practice :)
        }

        return response;
    }
}