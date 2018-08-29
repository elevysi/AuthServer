package com.elevysi.site.auth.config.security.jwt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;


@Component
public class JWTTokenEnhancer implements TokenEnhancer{
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication){
		Map<String, Object> additionalinfo = new HashMap<>();
		String siteId = "Elevysi";
		additionalinfo.put("hello", siteId);
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalinfo);
		return accessToken;
	}
}
