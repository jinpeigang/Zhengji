package com.jpg.hebei.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.SuserDao;
import com.jpg.hebei.model.Suser;
import com.jpg.hebei.model.User;

@Component("suserDao")
public class SuserDaoImpl implements SuserDao{
       private HibernateTemplate hibernateTemplate;
	
	public boolean checkSuserByNamePass(Suser suser) {
		// TODO Auto-generated method stub
		List<Suser> susers=hibernateTemplate.find("from Suser su where su.username='"+suser.getUsername()+"' and su.password='"+suser.getPassword()+"' ");
		if(susers!=null&&susers.size()>0)
		{
			return true;
		}
		return false;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public Suser loadByUsername(String username) {
		List<Suser> susers=hibernateTemplate.find("from Suser su where su.username='"+username+"' ");		
		return susers.get(0);
	}
	@Override
	public void updatePassword(Suser suser) {
		hibernateTemplate.update(suser);
		
	}
	@Override
	public Suser loadByID(int id) {
		Suser suser=(Suser) hibernateTemplate.load(Suser.class, id);
		return suser;
	}

}
