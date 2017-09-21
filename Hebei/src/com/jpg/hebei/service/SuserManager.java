package com.jpg.hebei.service;

import com.jpg.hebei.model.Suser;
import com.jpg.hebei.model.User;

public interface SuserManager {
	public boolean logincheck(Suser suser);
	public Suser loadSuser(String username);
	public Suser loadSuser(int id);
	public void updatePassword(Suser suser);
}
