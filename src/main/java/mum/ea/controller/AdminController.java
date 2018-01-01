package mum.ea.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.config.GetCurrentUser;
import mum.ea.domain.EventGroup;
import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.domain.UserType;
import mum.ea.service.EventGroupService;
import mum.ea.service.RoleService;
import mum.ea.service.UserServiceImpl;

@Controller
public class AdminController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private EventGroupService eventGroupService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	GetCurrentUser getCurrentUser;
	
	private List<UserType> userType = new ArrayList<UserType>(Arrays.asList(UserType.values()));
	
	@GetMapping("/error")
	public String getBuildings(Model m) {
		m.addAttribute("fullPageMessage", "Greetings from Spring Boot!");
		return "fullPageMessage";
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user.setStatus(2);
		modelAndView.addObject("registrationForm", user);
		modelAndView.addObject("userType",userType);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ModelAndView saveUserRegistration(@Valid User user, BindingResult bindingResult,
			@RequestParam(value="verifypassword", required=false) String verifypassword) {
		ModelAndView modelAndView = new ModelAndView();
/*		if(user.getStatus() != 3)
			user.setStatus(2);*/
		
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user","Username already used");
			modelAndView.addObject("registrationForm", user);
			modelAndView.addObject("userType",userType);
			modelAndView.setViewName("registration");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("registrationForm", user);
			modelAndView.addObject("userType",userType);
			modelAndView.setViewName("registration");
		}else if(!verifypassword.trim().equals(user.getPassword().trim())) {
			bindingResult.rejectValue("password", "error.user", "Password not match");
			modelAndView.addObject("registrationForm", user);
			modelAndView.addObject("userType",userType);
			modelAndView.setViewName("registration");
		} else {
			
			Set<Role> roles = new HashSet();
			Set<EventGroup> groups = new HashSet();
			
			Role role = roleService.findById(user.getStatus());
			
			System.out.println(role);
			
			EventGroup group = new EventGroup();
			int indx = 1;
			group = eventGroupService.getGroup(indx);    //eventGroupService.getGroup(indx);
			groups.add(group);
			user.setRole(role);
			user.setGroups(groups);
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("registrationForm", new User());
			user.setStatus(2);
			modelAndView.addObject("userType",userType);
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String getAdmin(){
		return "admin/administration";
	}
	
	@RequestMapping(value="/admin/userapproval", method = RequestMethod.GET)
	public ModelAndView getForApproval() {
		ModelAndView model = new ModelAndView("admin/userapproval");
		
		List<User> userList = userService.findAll();
		model.addObject("userList",userList);
		return model;
	}
	
	@RequestMapping(value="/admin/userapprove", method = RequestMethod.GET)
	public String userApproved(ModelMap model, @RequestParam int id) {
		User user = userService.findUserById(id);
		user.setStatus(2);
		userService.enableUser(user);
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		
		return "admin/userapproval";
	}
	
	@RequestMapping(value="/admin/notapprove", method=RequestMethod.GET)
	public String delete(ModelMap model, @RequestParam int id) {
		
		userService.deleteUser(id);
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		
		return "admin/userapproval";
	}
}
