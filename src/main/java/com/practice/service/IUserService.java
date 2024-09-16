package com.practice.service;

import java.util.List;

import com.practice.model.User;

public interface IUserService {

	// list
	public List<User> lstUsers();

	// save
	public void saveUser(User u);

	// delete
	public void deleteUser(User u);

	// find
	public User findUser(int id);

}
