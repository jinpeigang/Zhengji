package com.jpg.hebei.service;

import com.jpg.hebei.model.Guser;

public interface GuserManager {
	public  boolean logincheck(Guser gu) throws Exception;
	public Guser loadGuser(String username);
}
