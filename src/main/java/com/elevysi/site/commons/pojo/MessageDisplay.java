package com.elevysi.site.commons.pojo;

public class MessageDisplay {
	
	private Integer id;
	private String messageAuthor;
	private String avatarUUID;
	
	public String getMessageAuthor() {
		return messageAuthor;
	}
	public void setMessageAuthor(String messageAuthor) {
		this.messageAuthor = messageAuthor;
	}

	private String messageContent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	
	public MessageDisplay(Integer id, String messageAuthor, String messageContent){
		this.id = id;
		this.messageAuthor = messageAuthor;
		this.messageContent = messageContent;
	}
	
	public MessageDisplay(Integer id, String messageAuthor, String messageContent, String avatarUUID){
		this.id = id;
		this.messageAuthor = messageAuthor;
		this.messageContent = messageContent;
		this.avatarUUID = avatarUUID;
	}
	
	
	public String getAvatarUUID() {
		return avatarUUID;
	}
	public void setAvatarUUID(String avatarUUID) {
		this.avatarUUID = avatarUUID;
	}
	
	
	

}
