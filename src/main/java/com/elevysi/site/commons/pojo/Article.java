package com.elevysi.site.commons.pojo;

import java.util.Date;

public class Article {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	
	private Date created = new Date();
	private Date modified = new Date();
	
	public Article(){
		
	}
	
	public Article(String name, String description, Double price){
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public String toString(){
		return "The article name "+this.name+ " and the description "+this.description + " at a price of "+this.getPrice();
	}
	
	

}