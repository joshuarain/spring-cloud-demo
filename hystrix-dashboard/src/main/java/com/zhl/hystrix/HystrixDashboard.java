package com.zhl.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author Lenovo
 * @title: HystrixDashboard
 * @projectName cloud
 * @description: TODO
 * @date 2019/12/12 10:42
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class,args);
    }

    /**
     * 2.0版本开始需要加
     * SpringCloud2.0版本，不再默认支持hystrix.stream路径输出。所以，还需要手动配置一个Servelt来进行访问，否则就会报404错误。网上的教程大多是1.5版本的，如果你用的是2.0版本，直接照着网上的教程做，这里就会被坑到。
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
