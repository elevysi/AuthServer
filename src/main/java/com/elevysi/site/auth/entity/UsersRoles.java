package com.elevysi.site.auth.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UsersRoles implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4451200514590042581L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private Integer user_id;
	
	
	private Integer role_id;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public Integer getRole_id() {
		return role_id;
	}


	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
}
