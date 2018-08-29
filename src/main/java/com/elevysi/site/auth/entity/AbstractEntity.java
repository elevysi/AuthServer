package com.elevysi.site.auth.entity;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity implements Serializable{
	
	public final static int  TITLE_IN_URL_MAX_LENGTH = 50;
	
	public String generateUUID(){
		 UUID uniqueKey = UUID.randomUUID();   
		 return uniqueKey.toString();
		 
	}
	
	public static String generateStaticUUID(){
		 UUID uniqueKey = UUID.randomUUID();   
		 return uniqueKey.toString();
	}

	public String constructUrlTitle(String title){
		if(title != null){
			String titleInUrl = title.trim().replaceAll("[^a-zA-Z0-9\\-\\s\\.]", "");
			
			titleInUrl = titleInUrl.replaceAll("[\\-| |\\.]+", "-");
			if(titleInUrl.length() > TITLE_IN_URL_MAX_LENGTH){
				return titleInUrl.substring(0, TITLE_IN_URL_MAX_LENGTH);
			}
			
			
			return titleInUrl;
		}
		//build the title that appears in the URL when accessing a podcast from the main application
		 
		
		return title;
	}
}
