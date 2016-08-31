package com.gft.poc.ms.netflix.rx.microservice.api;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.netflix.hystrix.HystrixObservable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import rx.Observable;

/**
 * Created by javier on 30/08/16.
 */
@Service
public class BookInfoClientImpl implements BookInfoClient {

    @Override
    public Observable<BookBasicInfo> getBookById(Integer bookId) {
        return Observable.just(new BookBasicInfo(bookId, "N/A", -1));
    }

}
