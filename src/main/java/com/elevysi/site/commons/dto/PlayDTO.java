package com.elevysi.site.commons.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class PlayDTO {

	private Integer id;
	private String url;
	private String embeddedUrl;
	
	@JsonBackReference(value="publication-play")
	private PublicationDTO publication;
	
	private String description;
	private String title;
	private long profileID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEmbeddedUrl() {
		return embeddedUrl;
	}
	public void setEmbeddedUrl(String embeddedUrl) {
		this.embeddedUrl = embeddedUrl;
	}
	public PublicationDTO getPublication() {
		return publication;
	}
	public void setPublication(PublicationDTO publication) {
		this.publication = publication;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getProfileID() {
		return profileID;
	}
	public void setProfileID(long profileID) {
		this.profileID = profileID;
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
	
	
}
