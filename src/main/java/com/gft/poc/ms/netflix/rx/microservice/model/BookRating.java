package com.gft.poc.ms.netflix.rx.microservice.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BookRating {

	@Id
    @GeneratedValue
    @Column(name="BOOK_ID")
	private Integer bookId;
	
	private Integer rating;
	
	public BookRating(){}
	
	public BookRating(Integer bookId, Integer rating) {
		super();
		this.bookId = bookId;
		this.rating = rating;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "BookRating [bookId=" + bookId + ", rating=" + rating + "]";
	}
	
}
