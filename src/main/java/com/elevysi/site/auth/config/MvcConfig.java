package com.elevysi.site.auth.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.elevysi.site.auth.interceptor.AbstractInterceptor;
import com.elevysi.site.auth.interceptor.ResourceInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.elevysi.site.auth.controller")
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean
    public UrlBasedViewResolver urlViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(0);
        return resolver;
    }
	
	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/jsp/nullLayouts/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}
	
	@Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        String[] defs = {"/WEB-INF/views/defs/default.xml"};
        tilesConfigurer.setDefinitions(defs);
        return tilesConfigurer;
    }
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/assets/");
	    registry.addResourceHandler("/resources_1_8/**").addResourceLocations("/resources/assets1.8/");
	    registry.addResourceHandler("/resources_1_9/**").addResourceLocations("/resources/assets1.9/");
	    registry.addResourceHandler("/resources_1_9_5/**").addResourceLocations("/resources/assets1.9.5/");
	    registry.addResourceHandler("/thematic_1_9/**").addResourceLocations("/resources/thematic1.9/");
	    registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
	    registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
	    registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
	    registry.addResourceHandler("/ng/**").addResourceLocations("/resources/ng/");
	    registry.addResourceHandler("/assests/**").addResourceLocations("/resources/assets1.8/");
	}
	
//	https://stackoverflow.com/questions/29953245/configure-viewresolver-with-spring-boot-and-annotations-gives-no-mapping-found-f , http://www.baeldung.com/spring-mvc-view-resolver-tutorial
//	https://o7planning.org/en/11689/spring-boot-interceptors-tutorial
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localInterceptor = new LocaleChangeInterceptor();
		localInterceptor.setParamName("locale");
		registry.addInterceptor(localInterceptor);
		registry.addInterceptor(new ResourceInterceptor()).addPathPatterns("/**").excludePathPatterns("/resources/**, /js/**, /img/**, /css/**, /ng/**");
        registry.addInterceptor(new AbstractInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
	}
	
//	https://www.concretepage.com/spring-4/spring-4-mvc-internationalization-i18n-and-localization-l10n-annotation-example
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:META-INF/messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	@Bean
    public LocaleResolver localeResolver(){
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("elevysiBlogCookie");
		resolver.setCookieMaxAge(3600);
		return resolver;
    }
	
//	https://stackoverflow.com/questions/25164885/spring-web-mvc-java-configuration-default-servlet-name
//	@Bean
//    public SimpleMappingExceptionResolver exceptionResolver() {
//        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
//        
//        Properties exceptionMappings = new Properties();
//        
//        exceptionResolver.setDefaultErrorView("error/exception_error");
//       
//        exceptionMappings.put("java.lang.Exception", "error/exception_error");
//        exceptionMappings.put("java.lang.RuntimeException", "error/exception_error");
//        
//        exceptionResolver.setExceptionMappings(exceptionMappings);
//
//        Properties statusCodes = new Properties();
//        statusCodes.put("error/404", "404");
//        statusCodes.put("error/error", "500");
//
//        exceptionResolver.setStatusCodes(statusCodes);
//
//        return exceptionResolver;
//    }
	
//	https://stackoverflow.com/questions/26118099/how-to-config-commonsmultipartresolver-in-spring4-without-xml-to-upload-file
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    resolver.setMaxUploadSize(20971520); //20MB
	    resolver.setMaxInMemorySize(1048576); //10MB
	    
	    return resolver;
	}
	
}