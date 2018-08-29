package com.elevysi.site.commons.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;


public class CategoryDTO {

	private Integer id;
	private String name;
	private Integer order;
	
	
	@JsonBackReference(value="publication-categories")
	private PublicationDTO publicationDTO;
	
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
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public PublicationDTO getPublicationDTO() {
		return publicationDTO;
	}
	public void setPublicationDTO(PublicationDTO publicationDTO) {
		this.publicationDTO = publicationDTO;
	}
	
	
}
