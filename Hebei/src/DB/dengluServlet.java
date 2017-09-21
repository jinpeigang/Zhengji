package DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class dengluServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public void destory()
	{}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out  =response.getWriter();
		HttpSession session = request.getSession(true);
		String rand = (String)session.getAttribute("rand"); 
		String input = request.getParameter("randcode"); 
		String userleibie="1";
		if(rand.equals(input)){ 
			String name=request.getParameter("user");
			String pass=request.getParameter("pwd");
			   DBBean db = new DBBean();
			String sql = "select * from puser where username='"+name+"'" ;
			String sql1 = "select * from xuser where username='"+name+"'" ;
			String sql2 = "select * from guser where username='"+name+"'" ; 
			
	        
	        	
				
					 try {
						 ResultSet rs = db.executeQuery(sql);
						if (rs.next()) {
							
						     if(pass.equals(rs.getString(2)))
						    
						     {   	 
						    	 userleibie="1";
						     session.setAttribute("userleibie",userleibie);
						    	    String companyName=rs.getString(3);
						    	    session.setAttribute("pwd",pass);
						    	    session.setAttribute("username",name);
						    	    session.setAttribute("name",rs.getString(4));
									session.setAttribute("companyName",companyName);								
								     session.setAttribute("legalRepresenttative",rs.getString(7));
								     session.setAttribute("CompanyAddress",rs.getString(8));
								     response.setHeader("refresh", "1;url=main.jsp");
						     }
						     else
						     {
						    	 
						    	 out.println("<script language='javaScript'> alert('密码不正确！请重新输入');</script>");
									response.setHeader("refresh", "1;url=login.html");
						     }
						}    
						else{
						      
						           rs= db.executeQuery(sql1); 
						           if (rs.next()) {
						    	
							     if(pass.equals(rs.getString(3)))
							    
							     {   
							    	 userleibie="2"; 
							     session.setAttribute("userleibie",userleibie);
							     session.setAttribute("pwd",pass);
						    	    session.setAttribute("username",name);
						    	    session.setAttribute("name",rs.getString(4));
						    	    session.setAttribute("bumen",rs.getString(8));
							    	    String companyName=rs.getString(3);
										session.setAttribute("companyName",companyName);
									     response.setHeader("refresh", "1;url=smain.jsp");
							     }
							     else
							     {   
							    	 out.println("<script language='javaScript'> alert('密码不正确！请重新输入');</script>");
										response.setHeader("refresh", "1;url=login.html");
							     }						     
						         }  
						  else{
						      rs= db.executeQuery(sql2); 
						     if (rs.next()) {
					    	 
						        if(pass.equals(rs.getString(2)))
						    
						        {   	
						    	    session.setAttribute("name",rs.getString(3));
								     response.setHeader("refresh", "1;url=gmain.jsp");
						        }
						        else
						        { 
						    	 out.println("<script language='javaScript'> alert('密码不正确！请重新输入');</script>");
									response.setHeader("refresh", "1;url=login.html");
						        }						     
					        }  
						else 
						{
							out.println("<script language='javaScript'> alert('用户名不存在！请重新输入');</script>");
							
							response.setHeader("refresh", "1;url=login.html");					
						}
						     }
						
						} 
						rs.close();
					 }catch (SQLException e) {
						// TODO Auto-generated catch block
						 out.print("<script>alert('输入不正确！请重新输入！');location.href='login.html';</script>"); 
					}
		        db.close();
		               
	        
		} else{ 
			 
			out.print("<script>alert('请输入正确的验证码！');location.href='login.html';</script>"); 
		}

	}
}
