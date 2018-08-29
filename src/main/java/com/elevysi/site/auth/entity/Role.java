package com.elevysi.site.auth.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8561184637783916879L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> userRoles;
	


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


	public List<User> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(List<User> userRoles) {
		this.userRoles = userRoles;
	}


	
	
}
