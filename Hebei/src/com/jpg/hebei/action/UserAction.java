package com.jpg.hebei.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jpg.hebei.model.User;
import com.jpg.hebei.service.UserManager;
import com.jpg.hebei.vo.UserRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport  implements ModelDriven,ServletResponseAware{
	
	private static final long serialVersionUID = 1L;
	private UserRegisterInfo userRegisterInfo ;
	private UserManager userManager;
	private User user;
	private javax.servlet.http.HttpServletResponse response;
	public String register() throws Exception {
		
		 response.setContentType("text/html;charset=UTF-8");
         response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
         PrintWriter out=response.getWriter(); 
         
		User u = new User();
		u.setUsername(userRegisterInfo.getUsername());
		u.setPassword(userRegisterInfo.getPassword());
		u.setCompanyName(userRegisterInfo.getCompanyName());
		u.setName(userRegisterInfo.getName());
		u.setCardID(userRegisterInfo.getCardID());
		u.setCompanynum(userRegisterInfo.getCompanynum());
		u.setLegalRepresenttative(userRegisterInfo.getLegalRepresenttative());
		u.setAddress(userRegisterInfo.getUsername());
		if(userManager.exists(u)) {
			out.print("<script>alert('用户名已存在！')</script>");
			out.print("<script>window.location.href='puser/zhuce.jsp'</script>");
			out.flush();
			out.close();
			return null;
		}
		
		userManager.add(u);
		out.print("<script>alert('注册成功！')</script>");
		out.print("<script>window.open('login.html','_parent')</script>");
		out.flush();
		out.close();
		return null;
	}
	
	public String loadUser()
	{
		this.user=userManager.loadUser(userRegisterInfo.getId());
		
		return "success";
	}
	
	public String updatePassword() throws IOException
	{
		 /*HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		int  id=Integer.parseInt((String) session.getAttribute("id"));
		User user=new User();
		user.setPassword(userRegisterInfo.getPassword());		
		user.setId(id);		
		userManager.updatePassword(user);*/
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        PrintWriter out=response.getWriter(); 
        
		this.user=userManager.loadUser(userRegisterInfo.getId());
		user.setPassword(userRegisterInfo.getPassword());
		
		userManager.updatePassword(user);
		out.print("<script>alert('密码已修改！')</script>");
		 out.print("<script>window.location.href='templete/open.html'</script>");
		out.flush();
		out.close();
		
		return null;
	}
	
	public Object getModel() {
		// TODO Auto-generated method stub
		return this.userRegisterInfo;
	}

	

	public UserRegisterInfo getUserRegisterInfo() {
		return userRegisterInfo;
	}
	@Resource
	public void setUserRegisterInfo(UserRegisterInfo userRegisterInfo) {
		this.userRegisterInfo = userRegisterInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public UserManager getUserManager() {
		return userManager;
	}
	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
}


