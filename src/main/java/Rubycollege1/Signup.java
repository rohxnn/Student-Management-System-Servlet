package Rubycollege1;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Signup() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String n=request.getParameter("userid");
		String p=request.getParameter("password");
		PrintWriter out=response.getWriter();
	
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   Statement stmt1=con.createStatement();
			   ResultSet rs1=stmt1.executeQuery("select * from admin where A_id='"+n+"' and A_pass='"+p+"'");
			   ResultSet rs=stmt.executeQuery("select * from staff where t_id='"+n+"' and t_pass='"+p+"'");
			  
//				if(!rs1.next())
//				{
//					System.out.println("hooo");
//					   RequestDispatcher rd=request.getRequestDispatcher("staff.html");
//					   rd.include(request, response);
//					   out.println("        <p style=\"position: absolute; right: 48%;    bottom: 47%;    font-style: oblique;    font-weight: bold;font-size: 12px; color: red;\">Incorrect UserId or Password</p>\r\n"
//						   		+ "");
//				}
//				do
//				{
				while(rs1.next())
				{
				   if(n.equals(rs1.getString("A_id"))&& p.equals(rs1.getString("A_pass")))
				   {
					   HttpSession session=request.getSession();
					   session.setAttribute("uname",n);
						response.sendRedirect("Adminlog");

				   }
//			   }while(rs1.next());			  

		}
				 if(!rs.next())
				   {	
					   RequestDispatcher rd=request.getRequestDispatcher("staff.html");
					   rd.include(request, response);
					   out.println("        <p style=\"position: absolute; right: 48%;    bottom: 47%;    font-style: oblique;    font-weight: bold;font-size: 12px; color: red;\">Incorrect UserId or Password</p>\r\n"
					   		+ "");
				   }
					do
					{
					  if(n.equals(rs.getString("t_id")) && p.equals(rs.getString("t_pass")))
					   {
						   HttpSession session=request.getSession();
						   session.setAttribute("uname",n);
							response.sendRedirect("T_log");
						 
					   }
						   
				   } while(rs.next());
				} catch (Exception e) {
			System.out.println(e);
		}

}}
