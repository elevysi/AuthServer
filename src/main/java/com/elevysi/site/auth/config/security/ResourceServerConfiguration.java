package com.elevysi.site.auth.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	//Only APIs calls are considered as resource server i.e. needing token
	@Override
    public void configure(HttpSecurity http) throws Exception{
        http
        .requestMatchers().antMatchers("/api/**")
        .and()
        .authorizeRequests()
          .antMatchers(HttpMethod.DELETE, "/v1/organizations/**")
          .hasRole("ADMIN")
          .anyRequest()
          .authenticated();
    }

}
