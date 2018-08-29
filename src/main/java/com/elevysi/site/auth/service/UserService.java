package com.elevysi.site.auth.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.metamodel.SingularAttribute;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elevysi.site.auth.dao.UserDAO;
import com.elevysi.site.auth.entity.User;
import com.elevysi.site.auth.utils.ActiveUser;
import com.elevysi.site.commons.dto.RoleDTO;
import com.elevysi.site.commons.dto.UploadDTO;
import com.elevysi.site.commons.dto.UserDTO;
import com.elevysi.site.commons.pojo.OffsetPage;
import com.elevysi.site.commons.pojo.Page.SortDirection;
import com.google.common.reflect.TypeToken;


@Service
public class UserService extends AbstractServiceImpl<User, Integer>{
	
	private UserDAO userDAO;
	private PasswordEncoder passwordEncoder;
	private ModelMapper modelMapper;
	
	@Autowired
	public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder, ModelMapper modelMapper){
		this.userDAO = userDAO;
		this.passwordEncoder = passwordEncoder;
		this.modelMapper = modelMapper;
	}
	
	public User saveUser(User user){
		
		Date now = new Date();
		user.setActive(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setCreated(now);
		user.setModified(now);
		return userDAO.save(user);
	}
	
	public User loadUserByUsername(String username){
		return userDAO.loadByUsername(username);
	}
	
	public UserDTO findUserDTOByUsername(String username){
		User user = userDAO.loadByUsername(username);
		UserDTO userDTO = null;
		if(user != null){
			userDTO = modelMapper.map(user, UserDTO.class);
			
			java.lang.reflect.Type targetListType = new TypeToken<Set<RoleDTO>>() {}.getType();
			Set<RoleDTO> rolesDTOs = modelMapper.map(user.getRoles(), targetListType);
			
			userDTO.setRoles(rolesDTOs);
		}
		return userDTO;
	}
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	public User findOneWithEmail(String email) {
		return userDAO.findByEmail(email);
	}
	
	public User updatePassword(String newPassword){
		ActiveUser activeUser = this.getActiveUser();
		String username = activeUser.getUsername();
		
		User dbUser = userDAO.findByUsername(username);
		if(dbUser != null){
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			dbUser.setPassword(encoder.encode(newPassword));
			Date now = new Date();
			dbUser.setModified(now);
			User savedUser = userDAO.saveEdited(dbUser);
			
			return savedUser;
		}
		
		return null;
	}
	
	public boolean comparePasswords(String givenPassword){
		ActiveUser activeUser = this.getActiveUser();
		String username = activeUser.getUsername();
		
		User dbUser = userDAO.findByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(givenPassword, dbUser.getPassword())){
			return true;
		}
		
		return false;
	}
	
	public ActiveUser getActiveUser(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return (ActiveUser)auth.getPrincipal();	
		}
		
		
		return null;	
	}
	
	public List<User> findAll(){
		return userDAO.findAll();
	}
	
	public OffsetPage buildOffsetPage(int pageIndex, int size,  SingularAttribute sortField, SortDirection sortDirection){
		return userDAO.buildOffsetPage(pageIndex, size, sortField, sortDirection);
	}
	
	public void registerUser(User user){
		
//		Date now = new Date();
//		
//		user.setActive(true);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		user.setPassword(encoder.encode(user.getPassword()));
//		
//		user.setCreated(now);
//		user.setModified(now);
//		
//		Role userRole = roleRepository.findByName("ROLE_USER");
//		if(userRole != null) user.getRoles().add(userRole);
//		
//		
//		
//		//Add a profile for this user
//		Profile userProfile = new Profile();
//		userProfile.setUser(user);
//		ProfileType userProfileType = profileTypeService.findOne("user");
//		if(userProfileType != null)	userProfile.setProfileType(userProfileType);
//		
//		userProfile.setName(user.getUsername());
//		userProfile.setCreated(now);
//		userProfile.setModified(now);
//		
//		user.getProfiles().add(userProfile);
//		User savedUser = userRepository.save(user);
//		Profile savedUserProfile = profileService.findByUserAndProfileType(savedUser, userProfileType);
//		
//		if(savedUserProfile != null){
//		
//			Publication publication = savePublication(savedUserProfile, savedUserProfile.getName());
//			if(publication != null){
//				savedUserProfile.setPublication(publication);
//				//Resave the new User Profile with the publication ID
//				profileDAO.update(savedUserProfile);
//			}
//			
//			
//			String savingPath = this.relativePathToDefaultAvatar;
//			
//			/*
//			 * Give profile a default profile picture
//			 * Can't save upload directly with profile Owner because of multiple mappings on link_id and updatable, insertable is set to false for Profile in favor of Post
//			 */
//			
//			Upload profilePicture = new Upload();
//			profilePicture.setPath(savingPath);
//			profilePicture.setLinkTable("profilePicture");		
//			profilePicture.setLinkId(savedUserProfile.getId());
//			String uploadKey = Upload.generateUUID();
//			profilePicture.setKeyIdentification(uploadKey);
//			profilePicture.setDisplay(true);
//			profilePicture.setAltText("profilePicture");
////			profilePicture.setUploadOwner(savedUserProfile);
//			
//			uploadService.saveUpload(profilePicture);
//		}
		
	}
	
//	@Autowired
//	private UserDAO userDAO;
//	
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//	
//	@Autowired
//	private RoleRepository roleRepository;
//	
//	
//	@Autowired
//	private UploadService uploadService;
//	
//	
//	
//	@Value("${relativePathToDefaultAvatar}")
//	private String relativePathToDefaultAvatar;
//	
//	
//	
//	
//	public User loadUserByUsername(String username){
//		return userDAO.loadByUsername(username);
//	}
//	
//	public void saveEdit(User user){
//		user.setActive(true);
//		userRepository.save(user);		
//	}
//	
//	public User getUser(String username){
//		return userRepository.findByUsername(username);
//	}
//	
//	public User getUser(Integer id){
//		return userRepository.findById(id);
//	}
//	
//	public Page<User> findPaginatedUsers(Integer pageNumber, Integer limit, String sortField, String sortDirection) {
//		
//		/**
//		 * Modify pageNumber to use 1 index instead of zero index pages
//		 */
//		
//		Page<User> requestedPage = userRepository.findAll(constructPageSpecification(pageNumber - 1, limit, sortField, sortDirection));
//		return requestedPage;
//		
//	}
//
//	public void delete(int id) {
//		
//		userRepository.delete(id);
//		
//	}
//
//
//	public List<User> findMatching(String term) {
//		return userRepository.searchFor(term);
//	}
//	
//	public List<User> findByTerm(String term) {
//		return userDAO.searchByTerm(term);
//	}
//
//	public User findOne(Integer id) {
//		
//		return userRepository.findById(id);
//	}
//
//	public void reloadCurrentProfile() {
//		
//		
////		ActiveUser activeUser = this.getActiveUser();
////		Profile userProfile = this.getActiveProfile();
////		
////		/**
////		 * ReFind Profile with new details
////		 */
////		Profile reloadedProfile = profileService.findOne(userProfile.getId());
////		activeUser.setActiveProfile(reloadedProfile);
//		
//	}
//	
////	public Profile getActiveProfile(){
////		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////		
////		if (!(auth instanceof AnonymousAuthenticationToken)) {
////			ActiveUser activeUser = (ActiveUser)auth.getPrincipal();
////			return activeUser.getUserProfile();	
////		}
////		
////		return null;
////	}
//	
//	
//
//	@PreAuthorize("hasRole('ADMIN')")
//	public List<User> getUsers(com.elevysi.site.blog.pojo.Page page){
//		return userDAO.getUsers(page);
//	}
//	
//
//	@PostAuthorize("returnObject.username == principal.username || hasRole('ADMIN')")
//	public User getUserById(int id){
//		return userDAO.findById(id);
//	}
//	
//	@PreAuthorize("#user.username == principal.username || hasRole('ADMIN')")
//	public User updateUser(User user){
//		Date now = new Date();
//		user.setModified(now);
//		return userDAO.update(user);
//	}
//	

}
