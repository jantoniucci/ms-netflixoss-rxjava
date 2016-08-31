package com.gft.poc.ms.netflix.rx.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackageClasses=EurekaApplication.class)
public class EurekaApplication {
	
    public static void main(String[] args) {
    	new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
    }
}
