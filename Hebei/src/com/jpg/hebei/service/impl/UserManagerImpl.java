package com.jpg.hebei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.UserDao;
import com.jpg.hebei.dao.impl.UserDaoImpl;
import com.jpg.hebei.model.User;
import com.jpg.hebei.service.UserManager;

@Component("userManager")
public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public boolean exists(User u) throws Exception {
		return userDao.checkUserExistsWithName(u.getUsername());
		
	}
	

	public void add(User u) throws Exception {
		userDao.save(u);
	}
	@Override
	public boolean logincheck(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUserByNamePass(user);
	}

	public User loadUser(String username) {
		// TODO Auto-generated method stub
		return userDao.loadByUsername(username);
	}
	@Override
	public void updatePassword(User user) {
		// TODO Auto-generated method stub
		userDao.updatePassword(user);
	}
	@Override
	public User loadUser(int id) {
		// TODO Auto-generated method stub
		return userDao.loadByID(id);
	}
}
