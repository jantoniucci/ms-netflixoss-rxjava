package com.gft.poc.ms.netflix.rx.microservice.api;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookRating;
import com.netflix.hystrix.HystrixObservable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rx.Observable;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by javier on 30/08/16.
 */
@FeignClient(value = "http://bookrating-microservice", fallback = BookRatingClientImpl.class)
public interface BookRatingClient {

    @RequestMapping(value = "/books/{bookId}", method = GET)
    public Observable<BookRating> getBookById(@PathVariable(value = "bookId") Integer bookId);

}

