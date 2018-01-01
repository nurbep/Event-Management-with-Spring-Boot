package mum.ea.initdata;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import mum.ea.domain.Role;
import mum.ea.domain.User;
import mum.ea.service.RoleService;
import mum.ea.service.UserService;

@Component
public class LoadInitData {
	
	@Autowired
	UserService usrService;
	@Autowired
	RoleService roleService;

	/*@Autowired
	UserService usrService;*/
	@EventListener
	public void load(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() != null) {
			loadUser();
			loadBuilding();
		}
	}

	public void loadUser() {
		Set<Role> roles = new HashSet<>();
		Role role = new Role(1,"Admin");
		User usr = new User();
		roles.add(role);
		roleService.addRole(role);
		usr.setActive(1);
		usr.setEmail("youremail@gmail.com");
		usr.setPassword("password");
		usr.setRole(role);
		
		usrService.saveUser(usr);

	}

	public void loadBuilding() {

	}

}
