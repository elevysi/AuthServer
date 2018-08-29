package com.elevysi.site.commons.pojo;

import java.util.Date;

import com.elevysi.site.commons.dto.ProfileDTO;

public class SearchResult {
	
	private int index;
	private String type;
	private String details;
//	private Upload upload;
	private String heading;
	
	private Object object;
	private Date created;
	private Date modified;
	
	private ProfileDTO author;
	
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

//	public Upload getUpload() {
//		return upload;
//	}
//
//	public void setUpload(Upload upload) {
//		this.upload = upload;
//	}

	

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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

	public ProfileDTO getAuthor() {
		return author;
	}

	public void setAuthor(ProfileDTO author) {
		this.author = author;
	}

	

}
