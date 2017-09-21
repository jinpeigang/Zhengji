package com.jpg.Test;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jpg.hebei.dao.InformationDao;
import com.jpg.hebei.model.Information;


public class HebeiTest extends TestCase{
  private  InformationDao dao;
  	@Before
  	public void setUp(){
  		ApplicationContext ac = new ClassPathXmlApplicationContext("/beans.xml");
		dao = (InformationDao) ac.getBean("informationDao");
  	}
	@Test
	public void test() {
		Information info = dao.loadByInformationId(113);
		int id=info.getID();
		Assert.assertEquals(113, id);
	}


}
