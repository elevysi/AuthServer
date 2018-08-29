package com.elevysi.site.commons.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ProfileTypeDTO {
	
	
	private Integer id;
	private String name;
	
	@JsonManagedReference
	private Set <ProfileDTO> profiles = new HashSet<ProfileDTO>();

	public Set<ProfileDTO> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<ProfileDTO> profiles) {
		this.profiles = profiles;
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

}
