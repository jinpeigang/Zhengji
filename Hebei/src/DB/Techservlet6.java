package DB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Techservlet3
 */
public class Techservlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Techservlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String str1=request.getParameter("tech4");
		String str2=request.getParameter("tech5");
		
		String sql="Select * From  国民经济行业$  where Code like '"+str1.substring(0, 1)+str2.substring(0, 2)+"%'";
		String code="";
		String arrCF="";
		DBBean db = new DBBean();
		ResultSet rs = db.executeQuery(sql);
		
		try 
		{
			while(rs.next())
			{
				code=rs.getString(1).substring(0, 5);
				if(!code.equals("00"))
				{
					arrCF +=code + rs.getString(2)+" ";

				}

			}
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.getWriter().print(arrCF);
		db.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
