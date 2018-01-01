package mum.ea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.domain.Role;
import mum.ea.repository.RoleRepository;

@Service
public class RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	public Role findByRole(String role) {
		return roleRepository.findByRole(role);
	}
	
	@Transactional
	public void addRole(Role role) {
		roleRepository.save(role);
	}
	public Role findById(int id) {
		return roleRepository.findById(id);
	}

}
