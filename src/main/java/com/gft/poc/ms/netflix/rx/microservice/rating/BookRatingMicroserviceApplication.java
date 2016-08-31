package com.gft.poc.ms.netflix.rx.microservice.rating;

import com.gft.poc.ms.netflix.rx.microservice.model.BookRating;
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
@SpringBootApplication(scanBasePackageClasses={BookRatingMicroserviceApplication.class, BookService.class})
public class BookRatingMicroserviceApplication {

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
    public Single<BookRating> getBookRating(@PathVariable Integer bookId) {
		return bookService.getBookRating(bookId);
	}

    public static void main(String[] args) {
    	new SpringApplicationBuilder(BookRatingMicroserviceApplication.class).web(true).run(args);
    }
}
