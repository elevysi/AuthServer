package com.elevysi.site.commons.pojo;

public class LatestPost {
	
	
	private Integer id;
	private String created;
	private String author;
	private String title;
	private String imageKey;
	private String slug;
	
	
	
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getImageKey() {
		return imageKey;
	}
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}

	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public LatestPost(Integer id, String title, String imageKey, String created, String author, String slug){
		this.id = id;
		this.title = title;
		this.imageKey = imageKey;
		this.created = created;
		this.author = author;
		this.slug = slug;
	}

}
