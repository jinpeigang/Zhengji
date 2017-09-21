package com.jpg.hebei.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jpg.hebei.dao.PageDao;
import com.jpg.hebei.model.Information;
import com.jpg.hebei.model.PageBean;
import com.jpg.hebei.model.Retrieve;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RetrieveAction extends ActionSupport implements ModelDriven ,ServletResponseAware{ 
	 private PageDao pageDao;
	   private int page=1;
	   private PageBean pageBean;
	   private List<Information> list;
	   private Retrieve retrieve;
	   private javax.servlet.http.HttpServletResponse response;
	   String hql;
	   
	 
	StringBuffer hql1=new StringBuffer("from Information ifn where 1=1 " );
	
	 public String fenye() throws IOException{
		   response.setContentType("text/html;charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
	        PrintWriter out=response.getWriter();      
	      if(retrieve.getBiaoyin1().equals("请选择")&&retrieve.getBiaoyin2().equals("请选择")&&retrieve.getBiaoyin3().equals("请选择"))
	      {   
			 out.print("<script>alert('请选择查询条件!')</script>");
			 out.print("<script>window.location.href='../suser/fjiansuo.jsp'</script>");
			}
	     if(!retrieve.getBiaoyin1().equals("请选择")&&retrieve.getTiaojian1().equals(""))
		 {    
			     
			 out.print("<script>alert('请选择查询条件!')</script>");
			 out.print("<script>window.location.href='suser/fjiansuo.jsp'</script>");
			
		 }
		 else
		 {
		
		 if(!retrieve.getBiaoyin1().equals("请选择"))
			{
			
			 if(retrieve.getBiaoyin4().equals("精确"))
			 {
				 hql1.append("and ifn."+retrieve.getBiaoyin1()+"='"+retrieve.getTiaojian1()+"'");
			 }
			if(retrieve.getBiaoyin4().equals("模糊"))	
			{
				hql1.append("and ifn."+retrieve.getBiaoyin1()+" like '"+retrieve.getTiaojian1()+"%'");
			}
				
			}
			if(!retrieve.getBiaoyin2().equals("请选择"))
			{
				hql1.append("and ifn."+retrieve.getBiaoyin2()+"='"+retrieve.getTiaojian2()+"'");
			}
			if(!retrieve.getBiaoyin3().equals("请选择"))
			{     
				
				hql1.append("and ifn.flage='"+retrieve.getBiaoyin3()+"'");
			}
		 }
			
			hql=hql1.toString();
			//System.out.println(dao.queryForPage(1, page)+"===");
			this.pageBean =pageDao.queryForPage(2, page,hql);
			HttpServletRequest request = ServletActionContext.getRequest ();
			request.setAttribute("list", this.pageBean.getList());
			
			if(pageBean.getAllRow()==0)
			{
				 out.print("<script>alert('不存在记录!')</script>");
				 out.print("<script>window.location.href='suser/fjiansuo.jsp'</script>");
				 out.flush();
				 out.close();
			}			
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
		return retrieve;
	}

	public Retrieve getRetrieve() {
		return retrieve;
	}
	@Resource
	public void setRetrieve(Retrieve retrieve) {
		this.retrieve = retrieve;
	}
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
}
