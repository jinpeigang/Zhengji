package com.jpg.hebei.dao;

import java.util.List;

import com.jpg.hebei.model.Information;

public interface InformationDao {
	public void save(Information ifn);
	public  Information loadByCompanyName(String companyName);
	public  boolean checkInformation(String CompanyName); 
	public List<Information> getInformations(String CompanyName);
	public Information loadByInformationId(int id);
	public void delByInformationId(int id);
	public void updateInformation(Information ifn);
	public List<Information> listInformations(int flage);
	public List<Information> listInformations(String guanli,int flage);
}
