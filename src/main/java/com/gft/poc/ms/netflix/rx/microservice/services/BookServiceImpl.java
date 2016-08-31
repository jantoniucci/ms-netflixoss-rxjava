package com.gft.poc.ms.netflix.rx.microservice.services;

import javax.annotation.PostConstruct;

import com.gft.poc.ms.netflix.rx.microservice.model.BookBasicInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookInfo;
import com.gft.poc.ms.netflix.rx.microservice.model.BookRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import rx.Scheduler;
import rx.Single;
import rx.schedulers.Schedulers;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private TransactionTemplate  transactionTemplate;
	
	@Value("${bookService.getBookBasicInfo.delay:}")
	private Integer basicInfoDelay;
	
	@Value("${bookService.getBookRating.delay:}")
	private Integer bookRatingDelay;
	
	@Autowired
	private TaskExecutor executor;
	
	private Scheduler scheduler;
	
	@PostConstruct
	protected void initializeScheduler(){
		scheduler = Schedulers.from(executor);
	}

	public Single<BookBasicInfo> getBookBasicInfo(Integer bookId){
		Single<BookBasicInfo> obs = Single.create(s -> {
			if(basicInfoDelay!=null){
				try {
					Thread.sleep(basicInfoDelay);
				} catch (Exception e) {}
			}
			BookBasicInfo v = new BookBasicInfo();
			s.onSuccess(v);
		});
		return obs.subscribeOn(scheduler);
	}
	
	public Single<BookRating> getBookRating(Integer bookId){
		Single<BookRating> obs =  Single.create(s -> {
			if(bookRatingDelay!=null){
				try {
					Thread.sleep(bookRatingDelay);
				} catch (Exception e) {}
			}
			BookRating bookRating = transactionTemplate.execute(status -> {
				BookRating v = new BookRating();
				return v;
			});
			s.onSuccess(bookRating);
		});
		return obs.subscribeOn(scheduler);
	}
	
}
