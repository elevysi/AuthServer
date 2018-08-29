package com.elevysi.site.commons.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


public class ProfileDTO {
	
	private Integer id;
	
	private String name;
	private String title;
	private String description;
	private Integer profile_type_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;
	
	@JsonManagedReference(value="profile-avatars")
	private Set<UploadDTO> profilePicture = new HashSet<UploadDTO>();
	
	@JsonManagedReference(value="profile-covers")
	private Set<UploadDTO> coverUploads = new HashSet<UploadDTO>();
	
	@JsonBackReference
	private ProfileTypeDTO profileType;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getProfile_type_id() {
		return profile_type_id;
	}


	public void setProfile_type_id(Integer profile_type_id) {
		this.profile_type_id = profile_type_id;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
	
	public Set<UploadDTO> getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(Set<UploadDTO> profilePicture) {
		this.profilePicture = profilePicture;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public ProfileTypeDTO getProfileType() {
		return profileType;
	}

	public void setProfileType(ProfileTypeDTO profileType) {
		this.profileType = profileType;
	}
	
	public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof ProfileDTO))
            return false;
 
        final ProfileDTO profileDTO  = (ProfileDTO)object;
 
        if (id != null && profileDTO.getId() != null) {
            return id.equals(profileDTO.getId());
        }
        return false;
    }


	public Set<UploadDTO> getCoverUploads() {
		return coverUploads;
	}


	public void setCoverUploads(Set<UploadDTO> coverUploads) {
		this.coverUploads = coverUploads;
	}

}
