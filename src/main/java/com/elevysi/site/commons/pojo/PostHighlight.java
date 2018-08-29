package com.elevysi.site.commons.pojo;

public class PostHighlight {
	
	private Integer id;
	private String created;
	private String author;
	private String title;
	private String imageKey;
	private String resume;
	private String postCategory;
	private String slug;
	
	
	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public String getPostCategory() {
		return postCategory;
	}


	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getImageKey() {
		return imageKey;
	}


	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}


	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}


	public PostHighlight(Integer id, String title, String imageKey, String created, String author, String resume, String slug){
		this.id = id;
		this.title = title;
		this.imageKey = imageKey;
		this.created = created;
		this.author = author;
		this.resume = resume;
		this.slug = slug;
	}
	
	public PostHighlight(Integer id, String title, String imageKey, String created, String author, String resume, String postCategory, String slug){
		this.id = id;
		this.title = title;
		this.imageKey = imageKey;
		this.created = created;
		this.author = author;
		this.resume = resume;
		this.postCategory = postCategory;
		this.slug = slug;
	}

}
