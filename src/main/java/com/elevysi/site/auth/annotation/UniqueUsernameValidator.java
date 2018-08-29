package com.elevysi.site.auth.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.elevysi.site.auth.dao.UserDAO;


public class UniqueUsernameValidator  implements ConstraintValidator<UniqueUsername, String>{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return userDAO.loadByUsername(username) == null;
	}

}
