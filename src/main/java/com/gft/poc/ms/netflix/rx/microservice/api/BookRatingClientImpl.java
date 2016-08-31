package com.gft.poc.ms.netflix.rx.microservice.api;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookRating;
import com.netflix.hystrix.HystrixObservable;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.stereotype.Service;
import rx.Observable;

/**
 * Created by javier on 30/08/16.
 */
@Service
public class BookRatingClientImpl implements BookRatingClient {

    @Override
    public Observable<BookRating> getBookById(Integer bookId) {
        return Observable.just(new BookRating(bookId, -1));
    }

}
