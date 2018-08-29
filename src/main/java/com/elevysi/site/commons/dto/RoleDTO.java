package com.elevysi.site.commons.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class RoleDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7854814977114532797L;
	private Integer id;
	private String name;
	
	@JsonBackReference
    private UserDTO userDTO;
	

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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

}
