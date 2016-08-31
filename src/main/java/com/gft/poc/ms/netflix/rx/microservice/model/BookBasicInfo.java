package com.gft.poc.ms.netflix.rx.microservice.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class BookBasicInfo {

	@Id
    @GeneratedValue
	private Integer id;
	private String name;
	private Integer length;
	
	public BookBasicInfo(){}
	
	public BookBasicInfo(Integer id, String name, Integer length) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BookBasicInfo [id=" + id + ", name=" + name + ", length="
				+ length + "]";
	}
	
}
