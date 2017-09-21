package com.jpg.hebei.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jpg.hebei.dao.PageDao;
import com.jpg.hebei.model.Information;
import com.jpg.hebei.model.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PageAction extends ActionSupport implements ModelDriven{
   
	   private PageDao pageDao;
	   private int page=1;
	   private PageBean pageBean;
	   private List<Information> list;
	   String hql;
	   
	  
	  HttpServletRequest request1=ServletActionContext.getRequest();	
		HttpSession session = request1.getSession(true);
		 String bumen = (String)session.getAttribute("bumen");
		 
	  public String list(){
		 
		  if(bumen.equals("1"))
			 {
				  hql="from Information ifn where ifn.flage=0";
			 }
		  else
			 {
			  hql="from Information ifn where ifn.flage=2 and ifn.guanli='"+bumen+"'"; 
			 }
		/*this.list=pageDao.findAllInformation();*/
	  Map request = (Map)ActionContext.getContext().get("request");
	   	//获取request然后以map键值对形式存储供页面struts2的<s:iterator>来遍历
	   		request.put("list", this.pageDao.findAllInformation(hql));
	   	return "success";
	   }
	   
	  public String fenye(){

		  if(bumen.equals("1"))
			 {
				  hql="from Information ifn where ifn.flage=0";
			 }
		  else
			 {
			  hql="from Information ifn where ifn.flage=2 and ifn.guanli='"+bumen+"'"; 
			 }
			//System.out.println(dao.queryForPage(1, page)+"===");
			this.pageBean =pageDao.queryForPage(2, page,hql);
			HttpServletRequest request = ServletActionContext.getRequest ();
			request.setAttribute("list", this.pageBean.getList());
			return "success";
		}

	public PageDao getPageDao() {
		return pageDao;
	}
	@Resource
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	public int getPage() {
		return page;
	}
 
	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<Information> getList() {
		return list;
	}

	public void setList(List<Information> list) {
		this.list = list;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return pageBean;
	}

	
	
}
