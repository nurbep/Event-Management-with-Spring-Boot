package mum.ea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	public Role findByRole(String role);
	public Role findById(int id);
}
