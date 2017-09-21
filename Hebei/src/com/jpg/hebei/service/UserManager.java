package com.jpg.hebei.service;

import com.jpg.hebei.model.User;

public interface UserManager {

	public abstract boolean exists(User u) throws Exception;

	public abstract void add(User u) throws Exception;
	public boolean logincheck(User user);
	public User loadUser(String username);
	public User loadUser(int id);
	public void updatePassword(User user);
}
