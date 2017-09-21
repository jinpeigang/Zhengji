package com.jpg.hebei.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jpg.hebei.model.Information;
import com.jpg.hebei.service.InformationManager;
import com.jpg.hebei.vo.InformationInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("informationAction")
@Scope("prototype")
public class InformationAction extends ActionSupport  implements ModelDriven,ServletResponseAware{

    private static final long serialVersionUID = 1L;
    private List<Information> ifns;
	private Information ifn;
	private InformationManager informationManager;
	private InformationInfo  informationInfo;
	
    private javax.servlet.http.HttpServletResponse response;
    String datetime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());//获取当前时间
    
	HttpServletRequest request1=ServletActionContext.getRequest();	
	HttpSession session = request1.getSession(true);
	
	 String CompanyName = (String)session.getAttribute("companyName");
	 String name = (String)session.getAttribute("name");
	 String bumen = (String)session.getAttribute("bumen");
// 征集表提交 *************************************	 
	public String addInformation() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
       PrintWriter out=response.getWriter();         
		Information ifn=new Information();
		ifn.setCompanyName(CompanyName);
		ifn.setCenManagement(informationInfo.getCenManagement());
		ifn.setCompanyAddress(informationInfo.getCompanyAddress());		
		ifn.setArea(informationInfo.getArea());
		ifn.setWorkWebSite(informationInfo.getWorkWebSite());
		ifn.setEmail(informationInfo.getEmail());
		ifn.setLegalRepresenttative(informationInfo.getLegalRepresenttative());
		ifn.setPostCode(informationInfo.getPostCode());
		ifn.setContactName(informationInfo.getContactName());
		ifn.setTelephone(informationInfo.getTelephone());
		ifn.setPhone(informationInfo.getPhone());
		ifn.setFax(informationInfo.getFax());
		ifn.setJGshuxing(informationInfo.getJGshuxing());
		ifn.setCompanyIntroduction(informationInfo.getCompanyIntroduction());
		ifn.setTechNeed(informationInfo.getTechNeed());
		ifn.setStartYear(informationInfo.getStartYear());
		ifn.setEndYear(informationInfo.getEndYear());
		ifn.setTechquest(informationInfo.getTechquest());
		ifn.setTechkey(informationInfo.getTechkey());	
		ifn.setTechgoal(informationInfo.getTechgoal());
		ifn.setKey1(informationInfo.getKey1());
		ifn.setKey2(informationInfo.getKey2());
		ifn.setKey3(informationInfo.getKey3());
		ifn.setKey4(informationInfo.getKey4());
		ifn.setKey5(informationInfo.getKey5());		
		ifn.setPlanSum(informationInfo.getPlanSum());
		ifn.setTechNeedMode(informationInfo.getTechNeedMode());
		ifn.setCoopIntentionUnit(informationInfo.getCoopIntentionUnit());
		ifn.setStudyType(informationInfo.getStudyType());
		ifn.setSbjectThird(informationInfo.getSbjectThird());
		ifn.setTechNeedField(informationInfo.getTechNeedField());
		ifn.setOther(informationInfo.getOther());
		ifn.setTNProfessionThird(informationInfo.getTNProfessionThird());
		ifn.setFlage(informationInfo.getFlage());
		ifn.setReason(informationInfo.getReason());
		ifn.setGuanli(informationInfo.getGuanli());
		ifn.setXname(informationInfo.getXname());
		ifn.setXriqi(informationInfo.getXriqi());
		ifn.setBname(informationInfo.getBname());
		ifn.setBriqi(informationInfo.getBriqi());
		ifn.setSuoding(informationInfo.getSuoding());		
		informationManager.add(ifn);
		
		
		out.print("<script>alert('已成功提交，请等待审核!')</script>");
		 out.print("<script>window.location.href='informationChakan.action'</script>");
		out.flush();
		out.close();
		return null;
	}
//根据id查询某个征集表信息******************************************
	public String loadInformation()
	{
		this.ifn=informationManager.loadInformation(informationInfo.getID());
		return "success";
	}
//判断某单位是否已填写过征集表***************************************	
	public String existsInformation()
	{
		Information ifn=new Information();
		ifn.setCompanyName(CompanyName);
		if(informationManager.existsInformation(ifn))
		{
			this.ifn=informationManager.loadInformation(CompanyName);
			return "ifn2";
		}
		else
		{
			return "ifn1";
		}
		
	}
//加载某单位所有征集表信息*****************************************
	public String loadMyInformations() throws IOException
	{     
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=response.getWriter(); 
	
		
		Information ifn=new Information();
		ifn.setCompanyName(CompanyName);
		if(informationManager.existsInformation(ifn))
		{
			this.ifns=informationManager.listMyInformations(CompanyName);
			return "success";
		}
		else
		{
			out.print("<script>alert('对不起，您还未填写征集信息!')</script>");
			 out.print("<script>window.location.href='templete/open.html'</script>");
			out.flush();
			out.close();
		return null;
		}
	}
	
//删除征集表****************************************************
	public String delInformation() throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=response.getWriter(); 
        
		informationManager.delInformation(informationInfo.getID());
		out.print("<script>alert('已成功删除!')</script>");
		 out.print("<script>window.location.href='informationChakan.action'</script>");
		out.flush();
		out.close();
		  
		return null;
	}
//更新征集表 ****************************************************	
	public String updateInformation() throws IOException
	{
	this.ifn=informationManager.loadInformation(informationInfo.getID());
		
		ifn.setTechNeed(informationInfo.getTechNeed());
		ifn.setTechquest(informationInfo.getTechquest());
		ifn.setTechkey(informationInfo.getTechkey());	
		ifn.setTechgoal(informationInfo.getTechgoal());
		ifn.setKey1(informationInfo.getKey1());
		ifn.setKey2(informationInfo.getKey2());
		ifn.setKey3(informationInfo.getKey3());
		ifn.setKey4(informationInfo.getKey4());
		ifn.setKey5(informationInfo.getKey5());		
		ifn.setPlanSum(informationInfo.getPlanSum());
		ifn.setCoopIntentionUnit(informationInfo.getCoopIntentionUnit());
		
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=response.getWriter(); 
        
		informationManager.updateInformation(ifn);
		out.print("<script>alert('修改成功!')</script>");
		 out.print("<script>window.location.href='informationChakan.action'</script>");
		out.flush();
		out.close();
		return null;
	}
//根据审核情况，列出征集表*********************************************************
	public String listInformation()
	{
		/*Information ifn=new Information();
		ifn.setFlage(informationInfo.getFlage());*/
		this.ifns=informationManager.listInformations(informationInfo.getFlage());
		return "success";
		
	}
//根据部门和通过形式审核列出征集表***************************************************
	public String BlistInformation()
	{
		this.ifns=informationManager.listInformations(bumen, informationInfo.getFlage());
		return "success";
	}
	
//形式审核******************************************************************
	public String updateIfnXshenhe() throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=response.getWriter(); 
        
		this.ifn=informationManager.loadInformation(informationInfo.getID());
		
		if(informationInfo.getReason1().equals("审核通过"))
		{
			ifn.setFlage(2);
			ifn.setXriqi(datetime);
			ifn.setGuanli(informationInfo.getGuanli());
			ifn.setXname(name);
			
		}
	
		if(informationInfo.getReason1().equals("审核不通过"))
		{
			ifn.setFlage(3);
			ifn.setReason(informationInfo.getReason());
			ifn.setXriqi(datetime);
			ifn.setXname(name);
		
		}
		informationManager.updateInformation(ifn);
		out.print("<script>alert('审核完成!')</script>");
		 out.print("<script>window.location.href='informationList.action'</script>");
		out.flush();
		out.close();
		return null;
	}
	//部门审核******************************************************************
		public String updateIfnBshenhe() throws IOException
		{
			response.setContentType("text/html;charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
	        PrintWriter out=response.getWriter(); 
	        
			this.ifn=informationManager.loadInformation(informationInfo.getID());
			
			if(informationInfo.getReason1().equals("审核通过"))
			{
				ifn.setFlage(4);
				ifn.setXriqi(datetime);
				ifn.setXname(name);
				
			}
		
			if(informationInfo.getReason1().equals("审核不通过"))
			{
				ifn.setFlage(5);
				ifn.setReason(informationInfo.getReason());
				ifn.setXriqi(datetime);
				ifn.setXname(name);
				
			}
			informationManager.updateInformation(ifn);
			out.print("<script>alert('审核完成!')</script>");
			 out.print("<script>window.location.href='informationList.action'</script>");
			out.flush();
			out.close();
			return null;
		}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return this.informationInfo;
	}

	public Information getIfn() {
		return ifn;
	}

	public void setIfn(Information ifn) {
		this.ifn = ifn;
	}

	public InformationManager getInformationManager() {
		return informationManager;
	}
	@Resource
	public void setInformationManager(InformationManager informationManager) {
		this.informationManager = informationManager;
	}

	public InformationInfo getInformationInfo() {
		return informationInfo;
	}
	@Resource
	public void setInformationInfo(InformationInfo informationInfo) {
		this.informationInfo = informationInfo;
	}

	public List<Information> getIfns() {
		return ifns;
	}

	public void setIfns(List<Information> ifns) {
		this.ifns = ifns;
	}


	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
		
}
