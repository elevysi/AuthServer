package com.elevysi.site.commons.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class UploadDTO {

	private Integer id;
	private String title;
	private String description;
	private String filename;
	private Integer filesize;
	private String filemine;
	private String path;
	private String file_identificator;
	private String pathOriginal;
	

	private Date created;
	
	private Date modified;
	
	@JsonBackReference(value="profile-avatars")
	private ProfileDTO owningProfilePicture;
	
	@JsonBackReference(value="profile-covers")
	private ProfileDTO owningCoverUpload;
	
	@JsonBackReference(value="publication-uploads")
	private PublicationDTO publication;
	
	private String url;
	
	private String keyIdentification;
	
	@JsonBackReference(value="post-upload")
	private PostDTO post;
	
	public String getPathOriginal() {
		return pathOriginal;
	}

	public void setPathOriginal(String pathOriginal) {
		this.pathOriginal = pathOriginal;
	}

	private String linkTable;
	
	private Integer linkId;
	
	public String getLinkTable() {
		return linkTable;
	}

	public void setLinkTable(String linkTable) {
		this.linkTable = linkTable;
	}

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	private String altText;
	

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}

	public String getKeyIdentification() {
		return keyIdentification;
	}

	public void setKeyIdentification(String keyIdentification) {
		this.keyIdentification = keyIdentification;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String uuid;
	
	private boolean display;
	

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ProfileDTO getOwningProfilePicture() {
		return owningProfilePicture;
	}

	public void setOwningProfilePicture(ProfileDTO owningProfilePicture) {
		this.owningProfilePicture = owningProfilePicture;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Integer getFilesize() {
		return filesize;
	}

	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}

	public String getFilemine() {
		return filemine;
	}

	public void setFilemine(String filemine) {
		this.filemine = filemine;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFile_identificator() {
		return file_identificator;
	}

	public void setFile_identificator(String file_identificator) {
		this.file_identificator = file_identificator;
	}

	

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	/**
	 * https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
	 * http://www.baeldung.com/java-hashcode
	 */
	@Override
	public int hashCode() {
//	    return id.hashCode();
	    return id != null ? id.hashCode() : 0; //https://stackoverflow.com/questions/21535029/what-must-be-hashcode-of-null-objects-in-java
	}
	
	public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof UploadDTO))
            return false;
 
        final UploadDTO uploadDTO  = (UploadDTO)object;
 
        if (id != null && uploadDTO.getId() != null) {
            return id.equals(uploadDTO.getId());
        }
        return false;
    }

	public PostDTO getPost() {
		return post;
	}

	public void setPost(PostDTO post) {
		this.post = post;
	}

	public PublicationDTO getPublication() {
		return publication;
	}

	public void setPublication(PublicationDTO publication) {
		this.publication = publication;
	}

	public ProfileDTO getOwningCoverUpload() {
		return owningCoverUpload;
	}

	public void setOwningCoverUpload(ProfileDTO owningCoverUpload) {
		this.owningCoverUpload = owningCoverUpload;
	}


}
