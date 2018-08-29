//package com.elevysi.site.auth.config.security.jwt;
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties.SessionCreationPolicy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
//import com.elevysi.site.auth.config.CustomUserDetailsService;
//import com.elevysi.site.auth.utils.ActiveUser;
//
//@Configuration
//@EnableWebSecurity
//public class OAuth2ServerConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//	@Qualifier("customUserDetailsService")
//	private CustomUserDetailsService userDetailsService;
//	
//	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//	
//	 @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.userDetailsService(userDetailsService);
//        auth.authenticationProvider(authenticationProvider());
//    }
//    
//    
//    @Override
//    public void configure(WebSecurity webSecurity) throws Exception{
//        webSecurity
//            .ignoring()
//            .antMatchers("/resources/**")
//            .antMatchers("/resources_1_8/**")
//            .antMatchers("/js/**")
//            .antMatchers("/css/**")
//            .antMatchers("/img/**")
//            .antMatchers("/ng/**")
//            .antMatchers("/assets/**")
//            .antMatchers("/resources_1_9/**")
//            .antMatchers("/resources_1_9_5/**")
//            .antMatchers("/thematic_1_9/**");
//    }
//    
//    @Configuration
//	@EnableAuthorizationServer
//	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//    	
//    	@Autowired
//		private AuthenticationManager authenticationManager;
//		
//		
//		@Autowired
//		@Qualifier("customUserDetailsService")
//		private CustomUserDetailsService userDetailsService;
//		
//		
//		@Value("${signing.key}")
//		private String jwtSiginingKey="";
//
//		public String getJwtSiginingKey() {
//			return jwtSiginingKey;
//		}
//		
//		@Autowired
//		private JWTTokenEnhancer jwtTokenEnhancer;
//		
//		
//		@Bean
//	    public TokenEnhancer tokenEnhancer() {
//	        return new JWTTokenEnhancer();
//	    }
//			
//		@Autowired
//		private DataSource dataSource;
//		
//		@Autowired
//		private PasswordEncoder passwordEncoder;
//		
//		private DefaultAccessTokenConverter getAuthenticationAccessTokenConverter() {
//		    return new DefaultAccessTokenConverter() {
//		        @Override
//		        public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
//		            OAuth2Authentication authentication = (OAuth2Authentication) super.extractAuthentication(map);
//
//		            OAuth2AuthenticationUser authenticationUser =
//		                    new OAuth2AuthenticationUser(authentication.getOAuth2Request(), authentication.getUserAuthentication());
//
//		            String username = map.get("user_name")!= null? map.get("user_name").toString() : null;
//		            String password = map.get("password")!= null? map.get("password").toString() : null;
//		            String first_name = map.get("first_name")!= null? map.get("first_name").toString() : null;
//		            String siteID = map.get("hello")!= null? map.get("hello").toString() : null;
////		            List<GrantedAuthority> authorities = map.get("authorities")!= null? (ArrayList<GrantedAuthority>)map.get("first_name") : null;
//		            
//		            System.out.println("The site ID is "+siteID);
//		            
//		            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		            
//		            ActiveUser activeUser = new ActiveUser(
//		            		"elevysi",
//		            		"dummyPass",
//		            		true,
//		            		true,
//		            		true,
//		            		true,
//		            		authorities,
//		            		first_name
//	        		);
//		            authenticationUser.setActiveUser(activeUser);
//
//		            return authenticationUser;
//		        }
//		    };
//		}
//		
//		@Bean
//		public JwtAccessTokenConverter jwtAccessTokenConverter() {
//		    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//		    converter.setSigningKey(jwtSiginingKey);
//		    converter.setAccessTokenConverter(getAuthenticationAccessTokenConverter());
//		    return converter;
//		}
//		
//		@Bean
//		public TokenStore tokenstore(){
//			return new JwtTokenStore(jwtAccessTokenConverter());
//		}
//		
//		
//		@Override
//		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
//			TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//			tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer));
////			tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
//			
//			endpoints
//				.tokenStore(tokenstore())
//				.accessTokenConverter(jwtAccessTokenConverter())
//				.authenticationManager(authenticationManager)
//				.userDetailsService(userDetailsService)
////				.tokenEnhancer(tokenEnhancerChain)
////				.tokenEnhancer(jwtTokenEnhancer)
//				;
//			
//		}
//		
//		@Override
//	    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//	        security.passwordEncoder(passwordEncoder);
//	        security.allowFormAuthenticationForClients();
//	    }
//		
//		@Override
//		public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
//			/**
//			 * Auto Approve Client
//			 * https://stackoverflow.com/questions/29696004/skip-oauth-user-approval-in-spring-boot-oauth2
//			 * 
//			 */
//			clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
//			
//			
//		}
//		
//    }
//	
//    @Configuration
//    @Order(2)
//    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            
//            http
//        	.requestMatchers()
//        		.antMatchers("/login", "/oauth/authorize", "/ui/**") //If the context is not defined here, xml response with Full Authentication required
//    		.and()
//    		.authorizeRequests()
//    		.antMatchers("/ui/public/**").permitAll()
//    		.anyRequest().authenticated()
//    		.and()
//	          .formLogin().permitAll()
//	          .loginPage("/login"); 
//        }
//    }
//    
//    @Order(1)
//    @Configuration
//    @EnableResourceServer
//    public static class CustomResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
//
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//
//        	
//            http
//            .requestMatchers()
//    		.antMatchers("/api/**", "oauth/token") 
//            .and()
//                    .anonymous().disable()
//                    .sessionManagement()
//                    .sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS)
//                    .and().
//                    httpBasic()
//                    .and()
//                    .exceptionHandling()
////                    .accessDeniedHandler(accessDeniedHandler()) // handle access denied in general (for example comming from @PreAuthorization
////                    .authenticationEntryPoint(entryPointBean()) // handle authentication exceptions for unauthorized calls.
////                    .defaultAuthenticationEntryPointFor(entryPointBean(), preferredMatcher)
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/api/**").fullyAuthenticated();
//        }
//    }
//	
//}