package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T_reg
 */
@WebServlet("/T_reg")
public class T_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String sex=request.getParameter("gender");
		int ph_no=Integer.parseInt(request.getParameter("ph_no"));
		String branch=request.getParameter("Branch");
		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			    Statement stmt1=con.createStatement();
			    ResultSet rs=stmt1.executeQuery("select count(*) from staff");
			    int c=0;
			    while(rs.next())
			    {
			    	c=rs.getInt("count(*)");
			    }
			    c++;
			   
			   
			   PreparedStatement stmt=con.prepareStatement("insert into staff(t_id,t_name,t_pass,t_email,t_no,branch,sex) values('t_"+c+"','"+name+"','"+pass+"','"+email+"','"+ph_no+"','"+branch+"','"+sex+"')");
			   int i=stmt.executeUpdate();
			   if(i==1)
			   {
				   response.sendRedirect("Adminlog");
			   }
			   
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

}
