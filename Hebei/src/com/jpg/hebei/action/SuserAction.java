package com.jpg.hebei.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jpg.hebei.model.Suser;
import com.jpg.hebei.service.SuserManager;
import com.jpg.hebei.vo.SuserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("suserAction")
@Scope("prototype")
public class SuserAction extends ActionSupport  implements ModelDriven,ServletResponseAware{
	
	private static final long serialVersionUID = 1L;
	private SuserManager suserManager;
	private Suser suser;
	private SuserInfo suserInfo;
	private javax.servlet.http.HttpServletResponse response;
	
	public String loadSuser()
	{
		this.suser=suserManager.loadSuser(suserInfo.getID());
		return "success";
	}
	
	public String updatePassword() throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=response.getWriter(); 
     
        this.suser=suserManager.loadSuser(suserInfo.getID());
		suser.setPassword(suserInfo.getPassword());
		
		suserManager.updatePassword(suser);
		out.print("<script>alert('密码已修改！')</script>");
		 out.print("<script>window.location.href='templete/open.html'</script>");
		out.flush();
		out.close();
		
		return "success";
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return this.suserInfo;
	}
	public SuserManager getSuserManager() {
		return suserManager;
	}
	@Resource
	public void setSuserManager(SuserManager suserManager) {
		this.suserManager = suserManager;
	}
	public Suser getSuser() {
		return suser;
	}
	
	public void setSuser(Suser suser) {
		this.suser = suser;
	}

	public SuserInfo getSuserInfo() {
		return suserInfo;
	}
	@Resource
	public void setSuserInfo(SuserInfo suserInfo) {
		this.suserInfo = suserInfo;
	}
}
