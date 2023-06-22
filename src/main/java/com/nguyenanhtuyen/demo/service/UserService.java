package com.nguyenanhtuyen.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenanhtuyen.demo.dao.UserDAO;
import com.nguyenanhtuyen.demo.entities.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public User loadUserByUsername(final String username) {
		return userDAO.loadUserByUsername(username);
	}
	
	public boolean checkLogin(User userForm) {
		return userDAO.checkLogin(userForm);
	}
}
