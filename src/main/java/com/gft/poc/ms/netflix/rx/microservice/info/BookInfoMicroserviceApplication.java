package com.gft.poc.ms.netflix.rx.microservice.info;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.gft.poc.ms.netflix.rx.microservice.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;
import rx.Single;

@RestController
@EnableEurekaClient
@SpringBootApplication(scanBasePackageClasses={BookInfoMicroserviceApplication.class, BookService.class})
public class BookInfoMicroserviceApplication {

	@Value("${threadExecutor.corePoolSize:10}")
	private int corePoolSize;
	@Value("${threadExecutor.maxPoolSize:20}")
	private int maxPoolSize;
	
	@Bean
	public ThreadPoolTaskExecutor executor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(corePoolSize);
		executor.setMaxPoolSize(maxPoolSize);
		return executor;
	}
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/books/{bookId}", produces="application/json")
    public Single<BookBasicInfo> getBookInfo(@PathVariable Integer bookId) {
		return bookService.getBookBasicInfo(bookId);
	}
	
    public static void main(String[] args) {
    	new SpringApplicationBuilder(BookInfoMicroserviceApplication.class).web(true).run(args);
    }
}
