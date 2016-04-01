package com.stockmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanager.dao.UserDAO;
import com.stockmanager.models.User;

@Service("usersService")
public class UserService {

	private UserDAO userDAO;

	@Autowired
	public void setGoodsDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public boolean createUser(User user) {
		return userDAO.create(user);
	}


	public boolean exist(String username) {
		return userDAO.exists(username);
	}


}
