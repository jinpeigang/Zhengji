package com.jpg.hebei.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.GuserDao;
import com.jpg.hebei.model.Guser;
import com.jpg.hebei.model.Suser;
@Component("guserDao")
public class GuserDaoImpl implements GuserDao{
   private HibernateTemplate hibernateTemplate;
  

	public boolean checkGuserByNamePass(Guser guser) {
		
		List<Guser> gusers=hibernateTemplate.find("from Guser gu where gu.username='"+guser.getUsername()+"'and gu.password='"+guser.getPassword()+"'");
		if(gusers!=null&&gusers.size()>0)
		{
			return true;
		}
		return false;
	}
	public Guser loadGuser(String username)
	{
		List<Guser>  gusers=hibernateTemplate.find("from Guser gu where gu.username='"+username+"' ");		
		return gusers.get(0);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
