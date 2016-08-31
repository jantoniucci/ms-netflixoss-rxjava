package com.gft.poc.ms.netflix.rx.microservice.services;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookRating;
import rx.Single;

public interface BookService {

	Single<BookBasicInfo> getBookBasicInfo(Integer bookId);
	Single<BookRating> getBookRating(Integer bookId);

}
