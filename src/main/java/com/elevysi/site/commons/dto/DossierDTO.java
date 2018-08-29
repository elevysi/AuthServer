package com.elevysi.site.commons.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


public class DossierDTO {
	
	private Integer id;
	private String name;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	
	@JsonBackReference(value="publication-dossier")
	private PublicationDTO publication;
	
	@JsonManagedReference(value="dossier-publications")
	private Set<PublicationDTO> publications = new HashSet<PublicationDTO>();
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public PublicationDTO getPublication() {
		return publication;
	}
	public void setPublication(PublicationDTO publication) {
		this.publication = publication;
	}
	public Set<PublicationDTO> getPublications() {
		return publications;
	}
	public void setPublications(Set<PublicationDTO> publications) {
		this.publications = publications;
	}

}
