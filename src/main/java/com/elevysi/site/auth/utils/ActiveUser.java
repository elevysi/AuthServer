package com.elevysi.site.auth.utils;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;

public class ActiveUser extends User{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8778094825710419801L;
	private String first_name;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public ActiveUser(String username, String password, boolean enabled,
	         boolean accountNonExpired, boolean credentialsNonExpired,
	         boolean accountNonLocked,
	         Collection authorities,
	         String first_name
			) {

	             super(username, password, enabled, accountNonExpired,
	                credentialsNonExpired, accountNonLocked, authorities);
	             this.first_name = first_name;
     }
}
