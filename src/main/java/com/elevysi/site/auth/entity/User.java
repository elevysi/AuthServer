package com.elevysi.site.auth.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.elevysi.site.auth.entity.Role;


@Entity
@Table(name = "users")
public class User extends AbstractEntity implements Serializable{
	
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 5513701567464276239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, message="First Name must be at least 2 characters")
	@Column(nullable = false)
	private String first_name;
	
	@Size(min=2, message="First Name must be at least 2 characters")
	@Column(nullable = false)
	private String last_name;
	
	
	@Size(min=3, message="Username must be at least 3 characters")
	@Column(unique= true, nullable = false)
//	@UniqueUsername(message = "Such a username already exists")
	private String username;
	
	
	@Email(message = "A valid email address is required")
	@Column(nullable = false)
	private String email;
	
	
	private boolean active;
	
	@Size(min=5, message="Password must be at least 5 characters")
	@Column(nullable = false)
	private String password;

	@Column(name = "created", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Column(name = "modified", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="users_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
	private Set<Role> roles = new HashSet<Role>();
	
	
	private String country;
	private String town;
	private String street;
	private String postal_code;
	private String phone_number;
	private String uuid;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof User))
            return false;
 
        final User user = (User)object;
 
        if (id != null && user.getId() != null) {
            return id.equals(user.getId());
        }
        return false;
    }
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
