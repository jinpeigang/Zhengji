package com.jpg.hebei.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.jpg.hebei.dao.PageDao;
import com.jpg.hebei.model.Information;
import com.jpg.hebei.model.PageBean;
@Component("pageDao")
public class PageDaoImpl  implements PageDao{
	private HibernateTemplate hibernateTemplate;
	
	public List<Information> findAllInformation(String hql) {
		/*String hql = "from Information ifn where ifn.flage=0";
		return (List<Information>)hibernateTemplate.find(hql);*/
		List<Information> ifns=hibernateTemplate.find(hql);
		return ifns;
	}
	public int getAllRowCount(String hql) {
		return getHibernateTemplate().find(hql).size();
	}
	public List<Information> queryForPage(final String hql,final int offset,final int length){
		
		List list = this.hibernateTemplate.executeFind(new HibernateCallback(){           
			 public Object doInHibernate(Session session) throws HibernateException,SQLException{           
				 Query query = session.createQuery(hql);                
				 query.setFirstResult(offset);                 
				 query.setMaxResults(length);                 
				 List list = query.list();                
				 return list;             
				 }        
			 });         
		 return list;    
		}
	public PageBean queryForPage(int pageSize,int page,String hql){
	//	Fenye  fenye = new Fenye();
		/*final String hql = "from Information ifn where ifn.flage=0";*/
		
		int allRow = this.getAllRowCount(hql);
		int totalPage = PageBean.countTotalPage(pageSize,allRow);
		final int  offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		List<Information> list = this.queryForPage(hql,offset,length);
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		//pageBean.init();
		return pageBean;
	}
	/**
	 * 查询所有的记录数
	 * @param hql 查询条件
	 * @return 总记录数
	 *//*
	public int getAllRowCount(String hql)
	{
		return this.getHibernateTemplate().find(hql).size();
	}
  
	*//**
	 * 分页查询
	 * @param hql  查询条件
	 * @param offset  开始记录
	 * @param length  一次查询几条记录
	 * @return 查询的记录集合
	 *//*
	
	@SuppressWarnings("unchecked")
	public List<Information> queryForPage(final String hql,final int offset,final int length )
	{
		Session session=this.getSession();
		Query q=session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List<Information> list=q.list();
		System.out.println(list.size());
		session.close();
		return list;
	}*/
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}
