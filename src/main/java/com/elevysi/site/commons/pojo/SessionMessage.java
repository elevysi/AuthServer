package com.elevysi.site.commons.pojo;

public class SessionMessage {

		private String msgClass;
		private String msgText;
		public String getMsgClass() {
			return msgClass;
		}
		
		
		public void setMsgClass(String msgClass) {
			this.msgClass = msgClass;
		}
		public String getMsgText() {
			return msgText;
		}
		public void setMsgText(String msgText) {
			this.msgText = msgText;
		}
		
		public void setSuccessClass(){
			this.msgClass = "alert alert-success fade in alert-dismissable";
		}
		
		public void setDangerClass(){
			this.msgClass = "alert alert-danger fade in alert-dismissable";
		}
		
		public void setWarmingClass(){
			this.msgClass = "alert alert-warning fade in alert-dismissable";
		}
		
		public void setInfoClass(){
			this.msgClass = "alert alert-info fade in alert-dismissable";
		}
		
		public SessionMessage(String msgText, String msgClass) {
			super();
			this.msgClass = msgClass;
			this.msgText = msgText;
		}
		
		public SessionMessage(String msgText) {
			super();
			this.msgText = msgText;
			this.setInfoClass();
		}
		
		public SessionMessage(){
			this.setInfoClass();
		}
		
		
		
		
}
