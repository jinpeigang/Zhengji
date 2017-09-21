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

public class fjiansuoServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public void destory()
	{}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);
		 String biaoyin1=new String(request.getParameter("biaoyin1").getBytes("ISO8859-1"),"utf-8");
		 
		String biaoyin2=new String(request.getParameter("biaoyin2").getBytes("ISO8859-1"),"utf-8");
		String  biaoyin3=new String(request.getParameter("biaoyin3").getBytes("ISO8859-1"),"utf-8"); 
		String biaoyin4=new String(request.getParameter("biaoyin4").getBytes("ISO8859-1"),"utf-8");
		//String tiaojian1 =new String(request.getParameter("tiaojian1").getBytes("ISO8859-1"),"utf-8");
		String tiaojian2=new String(request.getParameter("tiaojian2").getBytes("ISO8859-1"),"utf-8");
		String tiaojian1=request.getParameter("tiaojian1");
		if(tiaojian1=="")
		{
			session.setAttribute("tiaojian1",tiaojian1);
		}
		else
			
		{
			String tiaojian3 =new String(request.getParameter("tiaojian1").getBytes("ISO8859-1"),"utf-8");
			session.setAttribute("tiaojian1",tiaojian3);
		}
		
		session.setAttribute("biaoyin1",biaoyin1);
		session.setAttribute("biaoyin2",biaoyin2);
		session.setAttribute("biaoyin3",biaoyin3);
		session.setAttribute("biaoyin4",biaoyin4);
		//session.setAttribute("tiaojian1",tiaojian1);
		session.setAttribute("tiaojian2",tiaojian2);
		 response.setHeader("refresh", "1;url=zjiansuo.jsp");
		
	}
}
