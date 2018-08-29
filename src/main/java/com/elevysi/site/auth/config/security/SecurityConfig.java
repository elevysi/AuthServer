package com.elevysi.site.auth.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.elevysi.site.auth.config.CustomUserDetailsService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private CustomUserDetailsService userDetailsService;
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	/**
	 * configure Global vs. Configure
	 * https://stackoverflow.com/questions/26348877/can-not-apply-daoauthenticationconfigurer-to-already-built-object
	 */
	
//	@Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());
//    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	/**
    	 * Differentiate Resource Server and Authentication Server
    	 * https://stackoverflow.com/questions/28908946/spring-security-oauth2-and-form-login-configuration
    	 */
    	
    	
        http
        	.requestMatchers()
        		.antMatchers("/login", "/oauth/authorize", "/ui/**") //If the context is not defined here, xml response with Full Authentication required
    		.and()
    		.authorizeRequests()
    		.antMatchers("/ui/public/**").permitAll()
    		.anyRequest().authenticated()
    		.and()
	          .formLogin().permitAll()
	          .loginPage("/login"); //Redirection Problem described here https:stackoverflow.com/questions/28197941/spring-oauth2-not-redirecting-back-to-client-on-form-login
        
        
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
    
    
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
    
    @Override
    public void configure(WebSecurity webSecurity) throws Exception
    {	
        webSecurity
            .ignoring()
            .antMatchers("/resources/**")
            .antMatchers("/resources_1_8/**")
            .antMatchers("/js/**")
            .antMatchers("/css/**")
            .antMatchers("/img/**")
            .antMatchers("/ng/**")
            .antMatchers("/assets/**")
            .antMatchers("/resources_1_9/**")
            .antMatchers("/resources_1_9_5/**")
            .antMatchers("/thematic_1_9/**");
        
    }

}