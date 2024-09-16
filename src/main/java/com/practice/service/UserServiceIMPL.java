package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.model.User;
import com.practice.repository.IUserRepository;

@Service
public class UserServiceIMPL implements IUserService {

	@Autowired
	IUserRepository repUser;

	@Override
	@Transactional(readOnly = true)
	public List<User> lstUsers() {

		return repUser.findAll();
	}

	@Override
	@Transactional
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		repUser.save(u);
	}

	@Override
	@Transactional
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		repUser.delete(u);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(int id) {
		// TODO Auto-generated method stuz
		return repUser.findById(id).orElse(null);
	}

}
