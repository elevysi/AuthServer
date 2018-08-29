package com.elevysi.site.commons.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


public class PublicationDTO {
	
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	private String friendlyUrl;
	private long profileID;
	private String profileName;
	
	@JsonManagedReference(value="publication-post")
	private PostDTO post;
	
	@JsonManagedReference(value="publication-play")
	private PlayDTO play;
	
	@JsonManagedReference(value="publication-dossier")
	private DossierDTO dossier;
	
	@JsonBackReference(value="dossier-publications")
	private DossierDTO dossierContainer;
	
	@JsonManagedReference(value="publication-categories")
	private Set<CategoryDTO> categories = new HashSet<CategoryDTO>();
	
	@JsonManagedReference(value="publication-uploads")
	private Set<UploadDTO> uploads = new HashSet<UploadDTO>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFriendlyUrl() {
		return friendlyUrl;
	}
	public void setFriendlyUrl(String friendlyUrl) {
		this.friendlyUrl = friendlyUrl;
	}
	public long getProfileID() {
		return profileID;
	}
	public void setProfileID(long profileID) {
		this.profileID = profileID;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public PostDTO getPost() {
		return post;
	}
	public void setPost(PostDTO post) {
		this.post = post;
	}
	public PlayDTO getPlay() {
		return play;
	}
	public void setPlay(PlayDTO play) {
		this.play = play;
	}
	
	public DossierDTO getDossier() {
		return dossier;
	}
	public void setDossier(DossierDTO dossier) {
		this.dossier = dossier;
	}
	
	public Set<CategoryDTO> getCategories() {
		return categories;
	}
	public void setCategories(Set<CategoryDTO> categories) {
		this.categories = categories;
	}
	public Set<UploadDTO> getUploads() {
		return uploads;
	}
	public void setUploads(Set<UploadDTO> uploads) {
		this.uploads = uploads;
	}
	
	

}
