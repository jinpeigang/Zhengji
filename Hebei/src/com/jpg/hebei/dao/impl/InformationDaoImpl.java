package com.jpg.hebei.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.InformationDao;
import com.jpg.hebei.model.Information;
import com.jpg.hebei.model.User;


@Component("informationDao")
public class InformationDaoImpl implements InformationDao{
	private HibernateTemplate hibernateTemplate;
	
	public void save(Information ifn) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(ifn);
	}
   
	public Information loadByCompanyName(String companyName)
	{
		List<Information> ifns=hibernateTemplate.find("from Information ifn where ifn.companyName = '" + companyName + "'");	
	     return ifns.get(0);
		
		
	}
	
	@Override
	public boolean checkInformation(String companyName) {
		// TODO Auto-generated method stub
		List<Information> ifn=hibernateTemplate.find("from Information ifn where ifn.companyName='"+companyName+"'");
		if(ifn!=null&&ifn.size()>0)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Information> getInformations(String companyName) {
		// TODO Auto-generated method stub
		List<Information> ifns=hibernateTemplate.find("from Information ifn where ifn.companyName='"+companyName+"'");
		return ifns;
	}

	@Override
	public Information loadByInformationId(int id) {
		// TODO Auto-generated method stub
		Information ifn=(Information) hibernateTemplate.load(Information.class, id);
		return ifn;
	}


	public void delByInformationId(int id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(loadByInformationId(id));
		
	}

	@Override
	public void updateInformation(Information ifn) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(ifn);
	}

	@Override
	public List<Information> listInformations(int flage) {
		// TODO Auto-generated method stub
	
		List<Information> ifns=hibernateTemplate.find("from Information ifn where ifn.flage='"+flage+"'");
		return ifns;
	}
	
	@Override
	public List<Information> listInformations(String guanli, int flage) {
		// TODO Auto-generated method stub
		
		List<Information> ifns=hibernateTemplate.find("from Information ifn where ifn.guanli='"+guanli+"' and ifn.flage='"+flage+"'");
		return ifns;
	}

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
}
