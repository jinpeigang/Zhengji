package com.jpg.hebei.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.jpg.hebei.dao.PageDao;
import com.jpg.hebei.model.Information;
import com.jpg.hebei.model.PageBean;
import com.jpg.hebei.model.Search;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HighSearchAction extends ActionSupport implements ModelDriven{
	private Search search;
	private PageDao pageDao;
	private  PageBean pageBean;
	private List<Information> list;
	private int page=1;
	private Map<String, Object> request;
	public String highSearch() throws UnsupportedEncodingException
	{  
		System.out.println(search.getSel0());//and or
		System.out.println(search.getSel2());//字段
		System.out.println(search.getSel3());//精确 模糊
		System.out.println(search.getSel4()); //审核结果
		System.out.println(java.net.URLDecoder.decode(search.getInputvalue(),"utf-8"));//字段内容
		
		//将字符串转换为jsonarray
				JSONArray jsel0 = JSONArray.fromObject(search.getSel0());
				JSONArray jsel2 = JSONArray.fromObject(search.getSel2());
				JSONArray jsel3 = JSONArray.fromObject(search.getSel3());
				JSONArray jiv = JSONArray.fromObject(search.getInputvalue());
				String s4=search.getSel4();
		
				StringBuffer hql=new StringBuffer("from Information ifn where 1=1 ");
				int length=jsel2.size();
				if(jsel3.getString(0).equals("jingque"))
				{
					hql.append(" and ifn."+jsel2.getString(0)+"='"+jiv.getString(0)+"'");
				}
				
				if(jsel3.getString(0).equals("mohu"))
				{
					hql.append("and ifn."+jsel2.getString(0)+" like '%"+jiv.getString(0)+"%'");
				}
				if(!s4.equals("请选择"))
				{
					hql.append(" and ifn.flage='"+s4+"'");
				}
				for(int i=01;i<length;i++)
				{
					if(jsel3.getString(i).equals("jingque"))
					{
						hql.append(""+jsel0.getString(i-1)+" (ifn."+jsel2.getString(i)+"='"+jiv.getString(i)+"')");
					}
					if(jsel3.getString(i).equals("mohu"))
					{
						hql.append(""+jsel0.getString(i-1)+" (ifn."+jsel2.getString(i)+" like '%"+jiv.getString(i)+"%')");
					}
				}
				
				System.out.println(hql.toString());
				
				this.pageBean =pageDao.queryForPage(2,page,hql.toString());
				System.out.println(this.pageBean.getList());
				HttpServletRequest request = ServletActionContext.getRequest ();
				request.setAttribute("list", this.pageBean.getList());
				System.out.println(1);
				
		return "success";
	}
	
	public PageDao getPageDao() {
		return pageDao;
	}
	@Resource
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public Search getSearch() {
		return search;
	}
	@Resource
	public void setSearch(Search search) {
		this.search = search;
	}
	
	public Object getModel() {
		
		return search;
	}
	

}
