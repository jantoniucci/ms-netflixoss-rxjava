package com.gft.poc.ms.netflix.rx.microservice.api;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.netflix.hystrix.HystrixObservable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import rx.Observable;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by javier on 30/08/16.
 */
@FeignClient(value = "http://bookinfo-microservice", fallback = BookInfoClientImpl.class)
public interface BookInfoClient {

    @RequestMapping(value = "/books/{bookId}", method = GET)
    public Observable<BookBasicInfo> getBookById(@PathVariable(value = "bookId") Integer bookId);

}

