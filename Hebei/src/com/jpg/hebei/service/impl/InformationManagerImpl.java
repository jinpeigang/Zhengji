package com.jpg.hebei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.InformationDao;
import com.jpg.hebei.model.Information;
import com.jpg.hebei.service.InformationManager;

@Component("informationManager")
public class InformationManagerImpl implements InformationManager {
	public InformationDao ifnDao;
	public void add(Information ifn) throws Exception {
		ifnDao.save(ifn);
	}
	public InformationDao getIfnDao() {
		return ifnDao;
	}
	@Resource
	public void setIfnDao(InformationDao ifnDao) {
		this.ifnDao = ifnDao;
	}
	@Override
	public Information loadInformation(String companyName) {
		
		return ifnDao.loadByCompanyName(companyName);
	}
	@Override
	public boolean existsInformation(Information ifn) {
		
		return ifnDao.checkInformation(ifn.getCompanyName());
	}
	@Override
	public List<Information> listMyInformations(String companyName) {
		
		return ifnDao.getInformations(companyName);
	}
	@Override
	public Information loadInformation(int id) {
		
		return ifnDao.loadByInformationId(id);
	}
	@Override
	public void delInformation(int id) {
		
		ifnDao.delByInformationId(id);
	}
	@Override
	public void updateInformation(Information ifn) {
		
		ifnDao.updateInformation(ifn);
	}
	@Override
	public List<Information> listInformations(int flage) {
		
		return ifnDao.listInformations(flage);
		
	}
	@Override
	public List<Information> listInformations(String guanli, int flage) {
		// TODO Auto-generated method stub
		return ifnDao.listInformations(guanli, flage);
	}
	
}
