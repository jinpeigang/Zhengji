package com.jpg.hebei.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.jpg.hebei.dao.UserDao;
import com.jpg.hebei.model.User;

@Component("userDao")
	public class UserDaoImpl implements UserDao {
     private HibernateTemplate hibernateTemplate;
		public void save(User u) {
			hibernateTemplate.save(u);
		}

		public boolean checkUserExistsWithName(String username) {
			
			List<User> users = hibernateTemplate.find("from User u where u.username = '" + username + "'");		
			if(users != null && users.size() > 0) {
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
		public boolean checkUserByNamePass(User user) {
			// TODO Auto-generated method stub
			
			List<User> users=  hibernateTemplate.find("from User u where u.username='"+user.getUsername()+"' and u.password='"+user.getPassword()+"'");
			if(users!=null&&users.size()>0)
			{
				return true;
			}
			return false;
		}

	
		public User loadByUsername(String username) {
			// TODO Auto-generated method stub
			List<User> users=hibernateTemplate.find("from User u where u.username = '" + username + "'");	
			return users.get(0);
		}

		@Override
		public void updatePassword(User user) {
			// TODO Auto-generated method stub
			hibernateTemplate.update(user);
			 /*HttpServletRequest request=ServletActionContext.getRequest();
				HttpSession session = request.getSession(true);
				int  id=Integer.parseInt((String) session.getAttribute("id"));
			String hql="update User u set u.password='"+user.getPassword()+"' where u.id='"+id+"'";
			SessionFactory session1 =HibernateUtil.getSessionFactory(); 
			Session s = session1.getCurrentSession();
			s.beginTransaction();  
		   org.hibernate.Query query =s.createQuery(hql);  
	        query.executeUpdate();  
	        s.getTransaction().commit();  */				
				
		}

		@Override
		public User loadByID(int id) {
			// TODO Auto-generated method stub
			User user=(User) hibernateTemplate.load(User.class, id);
			return user;
		}
		

	}
