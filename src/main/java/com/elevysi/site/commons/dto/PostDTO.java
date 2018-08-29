package com.elevysi.site.commons.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class PostDTO {

	private Integer id;
	private String title;
	private String description;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	@JsonManagedReference(value="post-upload")
	private Set<UploadDTO> uploads = new HashSet<UploadDTO>();
	
	@JsonBackReference(value="publication-post")
	private PublicationDTO publication;
	
	private long profileID;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Set<UploadDTO> getUploads() {
		return uploads;
	}
	public void setUploads(Set<UploadDTO> uploads) {
		this.uploads = uploads;
	}
	public PublicationDTO getPublication() {
		return publication;
	}
	public void setPublication(PublicationDTO publication) {
		this.publication = publication;
	}
	public long getProfileID() {
		return profileID;
	}
	public void setProfileID(long profileID) {
		this.profileID = profileID;
	}
	
	
}
