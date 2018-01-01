package mum.ea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import mum.ea.domain.User;
import mum.ea.repository.UserRepository;

@Service
public class GetCurrentUser {

	private String currentUser = null;
	
	@Autowired
	UserRepository usrRepo;
	
	public User loggedUser() {
		return usrRepo.findByEmail(getLoggedInUserName());
	}
	
	//private GetCurrentUser getCurrentUser;
	
	public GetCurrentUser(){}
	
	public String getLoggedInUserName() {
		String temp=null;
		Object principal = getUser(); //SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails){
			temp = principal.toString();
			
			String[] data = temp.split(";");
			String[] user = data[0].split("Username: ");
			currentUser = user[1].trim();
		}

		return currentUser;
	}
	
	public Object getUser() {
		return SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}
	
	public String getCurrentUserLogedin(){
		return currentUser;
	}
	
	public void logoutUser(){
		currentUser = null;
	}
}