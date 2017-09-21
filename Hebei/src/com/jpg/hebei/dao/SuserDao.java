package com.jpg.hebei.dao;

import com.jpg.hebei.model.Suser;
import com.jpg.hebei.model.User;

public interface SuserDao {
	public boolean checkSuserByNamePass(Suser suser); 
	public Suser loadByUsername(String username);
	public Suser loadByID(int id);
	public void updatePassword(Suser suser);
}
