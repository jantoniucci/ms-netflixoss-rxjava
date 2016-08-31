package com.gft.poc.ms.netflix.rx.microservice.model;

public class BookInfo {

	private BookBasicInfo basicInfo = new BookBasicInfo();
	private BookRating rating = new BookRating();
	
	public BookInfo() {}
	
	public BookInfo(BookBasicInfo basicInfo, BookRating rating) {
		super();
		this.basicInfo = basicInfo;
		this.rating = rating;
	}
	public Integer getLength() {
		return basicInfo!= null ? basicInfo.getLength() : null;
	}
	public Integer getId() {
		return basicInfo!= null ? basicInfo.getId() : null;
	}
	public String getName() {
		return basicInfo!= null ? basicInfo.getName() : null;
	}
	public Integer getRating() {
		return rating!=null ? rating.getRating() : null;
	}
	public void setRating(Integer rating) {
		this.rating = new BookRating(null, rating);
	}
	public void setLength(Integer length) {
		this.basicInfo.setLength(length);
	}
	public void setId(Integer id) {
		this.basicInfo.setId(id);
	}
	public void setName(String name) {
		this.basicInfo.setName(name);
	}
	@Override
	public String toString() {
		return "BookFullInfo [basicInfo=" + basicInfo + ", rating=" + rating
				+ "]";
	}
	
}
