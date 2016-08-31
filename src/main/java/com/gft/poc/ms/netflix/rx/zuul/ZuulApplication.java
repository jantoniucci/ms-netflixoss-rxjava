package com.gft.poc.ms.netflix.rx.zuul;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.stereotype.Controller;

@EnableZuulProxy
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication(scanBasePackageClasses=ZuulApplication.class)
public class ZuulApplication {
	
    public static void main(String[] args) {
    	new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }
}
