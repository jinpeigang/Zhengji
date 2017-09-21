package com.jpg.hebei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.GuserDao;
import com.jpg.hebei.model.Guser;
import com.jpg.hebei.service.GuserManager;

@Component("guserManager")
public class GuserManagerImpl implements GuserManager{
  
	private GuserDao guserDao;

	public boolean logincheck(Guser gu) throws Exception {
		
		return guserDao.checkGuserByNamePass(gu);
	}
	public GuserDao getGuserDao() {
		return guserDao;
	}
	@Resource
	public void setGuserDao(GuserDao guserDao) {
		this.guserDao = guserDao;
	}
	
	public Guser loadGuser(String username) {
	
		return guserDao.loadGuser(username);
	}

}
