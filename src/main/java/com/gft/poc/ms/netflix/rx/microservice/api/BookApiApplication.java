package com.gft.poc.ms.netflix.rx.microservice.api;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Single;
import rx.schedulers.Schedulers;

@RestController
@RequestMapping("/api")
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class BookApiApplication {

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
    BookInfoClient bookInfoClient;

    @Autowired
    BookRatingClient bookRatingClient;
	
	@RequestMapping(value="/books/{bookId}", produces="application/json")
    public Single<BookInfo> getBookInfo(@PathVariable Integer bookId) {
		Observable<BookBasicInfo> bookBasicInfo = bookInfoClient.getBookById(bookId);
		Observable<BookRating> bookRating = bookRatingClient.getBookById(bookId);

		return Observable.zip(bookBasicInfo, bookRating, (info, rating) -> {
			return new BookInfo(info, rating);
		}).toSingle();

    }

    public static void main(String[] args) {
    	new SpringApplicationBuilder(BookApiApplication.class).web(true).run(args);
    }
}
