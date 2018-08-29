package com.elevysi.site.auth.config.security.jwt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.elevysi.site.auth.config.CustomUserDetailsService;
import com.elevysi.site.auth.utils.ActiveUser;

import org.springframework.security.crypto.password.PasswordEncoder;

//http://www.baeldung.com/sso-spring-security-oauth2

@Configuration
@EnableAuthorizationServer
public class JWTOAuth2Config extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private CustomUserDetailsService userDetailsService;
	
	
	@Value("${signing.key}")
	private String jwtSiginingKey="";

	public String getJwtSiginingKey() {
		return jwtSiginingKey;
	}
	
	
	
//	@Autowired
//	private TokenEnhancer jwtTokenEnhancer;
	
	@Autowired
	private JWTTokenEnhancer jwtTokenEnhancer;
	
	
	@Bean
    public TokenEnhancer tokenEnhancer() {
        return new JWTTokenEnhancer();
    }
	
	
		
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@Autowired
//	private ServiceConfig serviceConfig;
	
	
//	@Autowired
//	private TokenStore tokenStore;
	
	@Bean
	public TokenStore tokenstore(){
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
//	@Autowired
//	private DefaultTokenServices tokenServices;
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices(){
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenstore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}
	
	
	
	
//	@Autowired
//	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	//https://stackoverflow.com/questions/47805115/spring-security-not-returning-userdetails-object-only-username
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
	    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	    converter.setSigningKey(jwtSiginingKey);
	    converter.setAccessTokenConverter(getAuthenticationAccessTokenConverter());
	    return converter;
	}
	
//	@Bean
//    public UserAuthenticationConverter userAuthenticationConverter () {
//        DefaultUserAuthenticationConverter duac  = new DefaultUserAuthenticationConverter();
//        duac.setUserDetailsService(userDetailsService);
//        return duac;
//    }
//	
//	@Bean
//    public AccessTokenConverter accessTokenConverter() {
//        DefaultAccessTokenConverter datc = new DefaultAccessTokenConverter();
//        datc.setUserTokenConverter(userAuthenticationConverter());
//        return datc;
//    }
	
	
	private DefaultAccessTokenConverter getAuthenticationAccessTokenConverter() {
	    return new DefaultAccessTokenConverter() {
	        @Override
	        public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
	            OAuth2Authentication authentication = (OAuth2Authentication) super.extractAuthentication(map);

	            OAuth2AuthenticationUser authenticationUser =
	                    new OAuth2AuthenticationUser(authentication.getOAuth2Request(), authentication.getUserAuthentication());

	            String username = map.get("user_name")!= null? map.get("user_name").toString() : null;
	            String password = map.get("password")!= null? map.get("password").toString() : null;
	            String first_name = map.get("first_name")!= null? map.get("first_name").toString() : null;
	            String siteID = map.get("hello")!= null? map.get("hello").toString() : null;
//	            List<GrantedAuthority> authorities = map.get("authorities")!= null? (ArrayList<GrantedAuthority>)map.get("first_name") : null;
	            
	            
	            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	            
	            ActiveUser activeUser = new ActiveUser(
	            		"elevysi",
	            		"dummyPass",
	            		true,
	            		true,
	            		true,
	            		true,
	            		authorities,
	            		first_name
        		);
	            authenticationUser.setActiveUser(activeUser);

	            return authenticationUser;
	        }
	    };
	}
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer));
//		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
		
		endpoints
			.tokenStore(tokenstore())
			.accessTokenConverter(jwtAccessTokenConverter())
			.authenticationManager(authenticationManager)
			.userDetailsService(userDetailsService)
//			.tokenEnhancer(tokenEnhancerChain)
//			.tokenEnhancer(jwtTokenEnhancer)
			;
		
	}
	
	@Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(passwordEncoder);
        security.allowFormAuthenticationForClients();
//        security.checkTokenAccess("permitAll");
    }
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
		/**
		 * Auto Approve Client
		 * https://stackoverflow.com/questions/29696004/skip-oauth-user-approval-in-spring-boot-oauth2
		 * 
		 */
		clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
		
		
	}
}