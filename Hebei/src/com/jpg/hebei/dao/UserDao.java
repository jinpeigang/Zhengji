package com.jpg.hebei.dao;

import com.jpg.hebei.model.User;

public interface UserDao {
	public void save(User u);
	public boolean checkUserExistsWithName(String username);
	public boolean checkUserByNamePass(User user);  
	public User loadByUsername(String username);
	public User loadByID(int id);
	public void updatePassword(User user);
}
