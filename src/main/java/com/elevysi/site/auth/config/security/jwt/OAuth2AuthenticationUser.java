package com.elevysi.site.auth.config.security.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import com.elevysi.site.auth.utils.ActiveUser;

public class OAuth2AuthenticationUser extends OAuth2Authentication{
	
	private ActiveUser activeUser;
	
	public ActiveUser getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(ActiveUser activeUser) {
		this.activeUser = activeUser;
	}

	public OAuth2AuthenticationUser(OAuth2Request storedRequest, Authentication userAuthentication) {
        super(storedRequest, userAuthentication);
    }
	
	
}
