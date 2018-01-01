package mum.ea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.ea.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 public User findByEmail(String email);
	 public User findById(int id);
	 public List<User> findAll();
}
