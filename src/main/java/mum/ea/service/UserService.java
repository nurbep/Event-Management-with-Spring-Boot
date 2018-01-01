package mum.ea.service;

import java.util.List;

import mum.ea.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public User findUserById(int id);
	public List<User> findAll();
	public void saveUser(User user);
	public void deleteUser(int id);
}