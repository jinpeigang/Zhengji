package com.jpg.hebei.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.jpg.hebei.model.Guser;
import com.jpg.hebei.model.Suser;
import com.jpg.hebei.model.User;
import com.jpg.hebei.service.GuserManager;
import com.jpg.hebei.service.SuserManager;
import com.jpg.hebei.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven,ServletResponseAware{
	  private String username;
	  private String password;
	  private String randcode;
	  private User user;
	  private Suser suser;
	  private Guser guser;
	  private UserManager userManager;
	  private SuserManager suserManager;
	  private GuserManager guserManager;
	  private javax.servlet.http.HttpServletResponse response;
	 
	  public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		public String getRandcode() {
			return randcode;
		}

		public void setRandcode(String randcode) {
			this.randcode = randcode;
		}
		
		public String login() throws Exception
		{  
			  response.setContentType("text/html;charset=UTF-8");
             response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
			PrintWriter out=response.getWriter();
		    HttpServletRequest request1=ServletActionContext.getRequest();
			HttpSession session = request1.getSession(true);
			String rand = (String)session.getAttribute("rand");
			
			if(getRandcode()!=null)
			{ 
				User u= new User();
				Suser su=new Suser();
				Guser gu=new Guser();
				u.setUsername(getUsername());
				u.setPassword(getPassword());
				su.setUsername(getUsername());
				su.setPassword(getPassword());
				gu.setUsername(getUsername());
				gu.setPassword(getPassword());
				
	  
				if(userManager.logincheck(u))
				{ 
					setUser(userManager.loadUser(getUsername()));
		            return "puser";
			    }
				else
				{ 
					if(suserManager.logincheck(su))
				   {
						setSuser(suserManager.loadSuser(getUsername()));
					   return "suser";
			       }
					else
					{ 
						if(guserManager.logincheck(gu))
						{ 
							setGuser(guserManager.loadGuser(getUsername()));
						return "guser";
						}
						
						out.print("<script>alert('用户名或密码错误!')</script>");
						 out.print("<script>window.location.href='login.html'</script>");
						out.flush();
						out.close();
						return null;
						
					}					
					
				}
			}
			   out.print("<script>alert('验证码错误!')</script>"); 
			   out.print("<script>window.location.href='login.html'</script>");
				out.flush();
				out.close();
			return null;
		}
		


public UserManager getUserManager() {
	return userManager;
}
@Resource
public void setUserManager(UserManager userManager) {
	this.userManager = userManager;
}
 @Override
 public Object getModel() {
 	// TODO Auto-generated method stub
 	return null;
 }

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public void setServletResponse(HttpServletResponse response) {
	// TODO Auto-generated method stub
	this.response = response;
}

public Suser getSuser() {
	return suser;
}

public void setSuser(Suser suser) {
	this.suser = suser;
}

public SuserManager getSuserManager() {
	return suserManager;
}
@Resource
public void setSuserManager(SuserManager suserManager) {
	this.suserManager = suserManager;
}

public Guser getGuser() {
	return guser;
}

public void setGuser(Guser guser) {
	this.guser = guser;
}

public GuserManager getGuserManager() {
	return guserManager;
}
@Resource
public void setGuserManager(GuserManager guserManager) {
	this.guserManager = guserManager;
}
}