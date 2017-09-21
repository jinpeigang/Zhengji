package com.jpg.hebei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.SuserDao;
import com.jpg.hebei.model.Suser;
import com.jpg.hebei.service.SuserManager;
@Component("suserManager")
public class SuserManagerImpl implements SuserManager{

	private SuserDao suserDao;
	
	@Override
	public boolean logincheck(Suser suser) {
		
		return suserDao.checkSuserByNamePass(suser);
	}

	public SuserDao getSuserDao() {
		return suserDao;
	}
	@Resource
	public void setSuserDao(SuserDao suserDao) {
		this.suserDao = suserDao;
	}

	@Override
	public Suser loadSuser(String username) {
		return suserDao.loadByUsername(username);
	}

	@Override
	public void updatePassword(Suser suser) {
		// TODO Auto-generated method stub
		suserDao.updatePassword(suser);
	}
	@Override
	public Suser loadSuser(int id)
	{
		return suserDao.loadByID(id);
	}

}
