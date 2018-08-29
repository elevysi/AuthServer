package com.elevysi.site.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;


import com.elevysi.site.auth.entity.User;
import com.elevysi.site.auth.entity.User_;
import com.elevysi.site.auth.service.UserService;
import com.elevysi.site.commons.pojo.OffsetPage;
import com.elevysi.site.commons.pojo.Page.SortDirection;

@Controller
@RequestMapping(value="/ui/admin")
public class AdminController extends AbstractController{
//	
	@Autowired
	private UserService userService;
//	
//	@Autowired
//	private RoleService roleService;
//	
//	@Autowired
//	private PostService postService;
//	
//	
//	@Autowired
//	private DossierService dossierService;
//	
//	@Autowired
//	private  CommentService commentService;
//	
//	@Autowired
//	private PlayService playService;
//	
//	@Autowired
//	private AlbumService albumService;
//	
//	@Autowired
//	private PublicationService publicationService;
//	
//	
////	@InitBinder
////    protected void initBinder(WebDataBinder binder) {
////        binder.registerCustomEditor(Set.class, "featuredPublications", new CustomCollectionEditor(Set.class)
////          {
////            @Override
////            protected Object convertElement(Object element)
////            {
////                Integer id = null;
////
////                if(element instanceof String && !((String)element).equals("")){
////                    //From the JSP 'element' will be a String
////                    try{
////                        id = Integer.parseInt((String) element);
////                    }
////                    catch (NumberFormatException e) {
//////                        System.out.println("Element was " + ((String) element));
////                        e.printStackTrace();
////                    }
////                }
////                else if(element instanceof Integer) {
////                    //From the database 'element' will be an Integer
////                    id = (Integer) element;
////                }
////
////                return id != null ? publicationService.getPublication(id).convertToMock() : null;
////            }
////          });
////    }
//
//	
//	@RequestMapping(value ="/dashboard", method = RequestMethod.GET)
//	public String adminDashboard(){
//		return "adminDashboard";
//		
//	}
//	
	@RequestMapping(value = {"/users"}, method = RequestMethod.GET)
	public String users(Model model, @RequestParam(value="page", defaultValue="1", required=false)int pageIndex){
		
		OffsetPage page = userService.buildOffsetPage(pageIndex, 20, User_.created, SortDirection.DESC);
		List<User> users = userService.findAll();
		long totalRecords = page.getTotalRecords();
		int totalPages = Math.round(totalRecords / 20);
		model.addAttribute("page", page);
		model.addAttribute("users", users);
		model.addAttribute("totalPages", totalPages);
		
		return "userIndex";
	}
//	
////	@RequestMapping(value = {"/profiles"}, method = RequestMethod.GET)
////	public String profiles(Model model, @RequestParam(value="page", defaultValue="1", required=false)int pageIndex){
////		
////		OffsetPage page = profileService.buildOffsetPage(pageIndex, DEFAULT_NO_ITEMS, Profile_.created, SortDirection.DESC);
////		List<Profile> profiles = profileService.getProfiles(page);
////		long totalRecords = page.getTotalRecords();
////		int totalPages = Math.round(totalRecords / DEFAULT_NO_ITEMS);
////		model.addAttribute("page", page);
////		model.addAttribute("profiles", profiles);
////		model.addAttribute("totalPages", totalPages);
////		
////		return "profileIndex";
////	}
//	
//	@RequestMapping(value = {"/users/add", "/users/add/"}, method = RequestMethod.GET)
//	public String add(Model model){
//		model.addAttribute("roles", roleService.findAllRoles());
//		return "userAdd";
//	}
//	
//	@RequestMapping(value = {"/users/edit/{id}"}, method = RequestMethod.GET)
//	public String edit(Model model, @PathVariable int id){
//		model.addAttribute("user", userService.getUser((Integer)id));
//		model.addAttribute("roles", roleService.findAllRoles());
//		return "userEdit";
//	}
//	
//	@RequestMapping(value = {"/users/delete/{id}"})
//	public String delete(Model model, @PathVariable int id, final RedirectAttributes redirectAttributes){
//		userService.delete(id);
//		SessionMessage sessionMessage = new SessionMessage("Successfully deleted!");
//		sessionMessage.setSuccessClass();
//		redirectAttributes.addFlashAttribute("sessionMessage", sessionMessage);		
//		return "redirect:/admin/users";
//	}
//	
//	@RequestMapping(value="/posts")
//	public String posts(Model model, @RequestParam(value="page", defaultValue="1", required=false)int pageIndex){
//		
//		
//		OffsetPage page = postService.buildOffsetPage(pageIndex, DEFAULT_NO_ITEMS, Post_.created, SortDirection.DESC);
//		List<Post> posts = postService.getAllPosts(page);
//		long totalRecords = page.getTotalRecords();
//		int totalPages = Math.round(totalRecords / DEFAULT_NO_ITEMS);
//		model.addAttribute("page", page);
//		model.addAttribute("posts", posts);
//		model.addAttribute("totalPages", totalPages);
//		
//		return "publicIndexPosts";
//	}
//	
//	@RequestMapping(value="/plays")
//	public String plays(Model model, @RequestParam(value="page", defaultValue="1", required=false)int pageIndex){
//		
//		OffsetPage page = playService.buildOffsetPage(pageIndex, DEFAULT_NO_ITEMS, Play_.created, SortDirection.DESC);
//		List<Play> plays = playService.getPlays(page);
//		long totalRecords = page.getTotalRecords();
//		int totalPages = Math.round(totalRecords / DEFAULT_NO_ITEMS);
//		model.addAttribute("page", page);
//		model.addAttribute("plays", plays);
//		model.addAttribute("totalPages", totalPages);
//		
//		return "publicIndexPlays";
//		
//	}
//	
//	@RequestMapping(value="/albums")
//	public String albums(Model model, @RequestParam(value="page", defaultValue="1", required=false)int pageIndex){
//		
//		OffsetPage page = albumService.buildOffsetPage(pageIndex, DEFAULT_NO_ITEMS, Album_.created, SortDirection.DESC);
//		List<Album> albums = albumService.getAlbums(page);
//		long totalRecords = page.getTotalRecords();
//		int totalPages = Math.round(totalRecords / DEFAULT_NO_ITEMS);
//		model.addAttribute("page", page);
//		model.addAttribute("albums", albums);
//		model.addAttribute("totalPages", totalPages);
//		
//		
//		return "publicIndexAlbums";
//		
//	}
//	
//	@RequestMapping(value="/dossiers")
//	public String dossiers(Model model, @RequestParam(value="page", defaultValue="1", required=false)int pageIndex){
//		
//		OffsetPage page = dossierService.buildOffsetPage(pageIndex, DEFAULT_NO_ITEMS, Dossier_.created, SortDirection.DESC);
//		List<Dossier> dossiers = dossierService.getDossiers(page);
//		long totalRecords = page.getTotalRecords();
//		int totalPages = Math.round(totalRecords / DEFAULT_NO_ITEMS);
//		model.addAttribute("page", page);
//		model.addAttribute("dossiers", dossiers);
//		model.addAttribute("totalPages", totalPages);
//		
//		
//		return "publicIndexDossiers";
//		
//	}
//	
//	@RequestMapping(value="/users/modalView/{id}")
//	public String view(@PathVariable("id")Integer id, Model model){
//		
//		User user = userService.getUserById(id);
//		
//		model.addAttribute("user", user);
//		return "modalUserView";
//	}
//	
//	
//	@RequestMapping(value="/users/modalEdit/{id}")
//	public String edit(@PathVariable("id")Integer id, Model model){
//		
//		User user = userService.getUserById(id);
//		List<Role> roles = roleService.findAllRoles();
//		model.addAttribute("roles", roles);
//		model.addAttribute("user", user);
//		return "modalUserEdit";
//	}
//	
//	@RequestMapping(value = {"/users/edit/{id}"}, method = RequestMethod.POST)
//	public String doEdit(Model model, @RequestParam("roles") String[] roles, @ModelAttribute("user") User user){
//		
//		for (String role_id : roles) {
//			Role role = roleService.findOne(Integer.parseInt(role_id));
//			user.getRoles().add(role);
//		}
//		
//		userService.saveEdit(user);
//		
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value = {"/users/modalEdit/{id}"}, method = RequestMethod.POST)
//	public @ResponseBody ReturnValue doUserEditAjax(@ModelAttribute("user") User user, BindingResult result){
//		ReturnValue returnValue = new ReturnValue();
//		returnValue.setCode(0);
//		returnValue.setMessage("Failed to edit this user");
//		
//		if(! result.hasErrors()){
//			User updatedUser = userService.updateUser(user);
//			if(updatedUser != null){
//				returnValue.setCode(1);
//				returnValue.setMessage("Successfully updated user!");
//			}
//		}
//		
//		return returnValue;
//	}
//	
////	@RequestMapping(value="profileTypes")
////	public String profileTypes(){
////		
////		
////		return "";
////	}
//	
//	@RequestMapping(value="featured")
//	public String featured(Model model){
//		AdminFeatured adminFeatured = new AdminFeatured();
//		model.addAttribute("adminFeatured", adminFeatured);
//		return "adminFeatured";
//	}
//	
//	@RequestMapping(value="featured", method=RequestMethod.POST)
//	public String doFeatured(Model model, @RequestParam("featuredPublications") String[] featuredPublications, RedirectAttributes redirectAttributes){
//		if(featuredPublications != null){
////			List<PublicationMock> chosen = adminFeatured.getFeaturedPublications();
//			
//			
//			for (String publication_id : featuredPublications) {
//				Publication dbPub = publicationService.getPublication(Long.parseLong(publication_id));
//				dbPub.setFeatured(true);
//				publicationService.saveEditedPublication(dbPub);
//			}
//			
//			SessionMessage sessionMessage = new SessionMessage("Featured items have been successfully set.");
//			sessionMessage.setSuccessClass();
//			redirectAttributes.addFlashAttribute(sessionMessage);
//			
//			return "redirect:/";
//			
//			
//		}
//		AdminFeatured adminFeatured = new AdminFeatured();
//		model.addAttribute("adminFeatured", adminFeatured);
//		return "adminFeatured";
//	}
//	
//	@RequestMapping(value="searchPublication")
//	public @ResponseBody List<PublicationMock> searchPublication(@RequestParam(value="term", required=true)String term){
//		List<PublicationMock> publications = new ArrayList<PublicationMock>();
//		List<Publication> foundPublications = publicationService.searchByTerm(term);
//		if(foundPublications != null){
//			for(Publication publication: foundPublications){
//				PublicationMock publicationMock = new PublicationMock();
//				publicationMock.createMockFromPublication(publication);
//				publications.add(publicationMock);
//			}
//		}
//		
//		
//		return publications;
//	}
//	
//	@RequestMapping(value="unfeatureItem", method=RequestMethod.POST)
//	public @ResponseBody ReturnValue doUnfeatureItem(@RequestParam("id")Long id){
//		ReturnValue returnValue = new ReturnValue();
//		returnValue.setCode(0);
//		returnValue.setMessage("Could not update the item");
//		Publication publication = publicationService.getPublication(id);
//		if(publication != null){
//			publication.setFeatured(false);
//			publicationService.saveEditedPublication(publication);
//			returnValue.setCode(1);
//			returnValue.setMessage("The publication was successfully unfeatured!");
//		}
//		return returnValue;
//	}
//	
//	@RequestMapping(value="featureItem", method=RequestMethod.POST)
//	public @ResponseBody ReturnValue doFeatureItem(@RequestParam("id")Long id){
//		ReturnValue returnValue = new ReturnValue();
//		returnValue.setCode(0);
//		returnValue.setMessage("Could not update the item");
//		Publication publication = publicationService.getPublication(id);
//		if(publication != null){
//			publication.setFeatured(true);
//			publicationService.saveEditedPublication(publication);
//			returnValue.setCode(2);
//			returnValue.setMessage("The publication was successfully featured!");
//		}
//		return returnValue;
//	}
}
