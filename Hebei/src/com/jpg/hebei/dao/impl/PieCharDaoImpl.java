package com.jpg.hebei.dao.impl;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.jpg.hebei.dao.PieCharDao;

@Component("pieCharDao")
public class PieCharDaoImpl implements PieCharDao {
	 private HibernateTemplate hibernateTemplate;
	 @Override	
	public List pieChar(String biaoyin) {
		/* SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.getCurrentSession();
			s.beginTransaction();*/
		 
		  String hql="select count(*) as hangshu,"+biaoyin+" from Information  group by "+biaoyin+"";
		  /*Query query = s.createQuery(hql);  
		  List list= query.list();  
		  s.getTransaction().commit();*/
		  List list=(List) hibernateTemplate.find(hql);
		  Iterator it= list.iterator();  
		     while(it.hasNext()){  
		        Object[] obj=(Object[]) it.next();  
		        //注意这里的类型转化  
		        int count=((Number)obj[0]).intValue();  
		 
		     }
		    return list; 
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
