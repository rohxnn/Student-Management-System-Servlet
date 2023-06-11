package students;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
		
		String id=request.getParameter("s_id");
		String pass=request.getParameter("s_pass");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from students where s_id='"+id+"' and s_pass='"+pass+"'");
			   if(!rs.next())
			   {
				   RequestDispatcher rd=request.getRequestDispatcher("studentlog.html");
				   rd.include(request, response);
				   out.println("        <p style=\"position: absolute; right: 48%;    bottom: 47%;    font-style: oblique;    font-weight: bold;font-size: 12px; color: red;\">Incorrect UserId or Password</p>\r\n"
				   		+ "");
			   } 
			   do
			   {
				   if(id.equals(rs.getString("s_id"))&& pass.equals(rs.getString("s_pass")))
				   {
					  
					   HttpSession session=request.getSession();
					   session.setAttribute("uname",id);
						response.sendRedirect("S_log");
//					   RequestDispatcher rd=request.getRequestDispatcher("S_log");
//					   rd.forward(request, response);
				   }}while(rs.next());}
		 catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
		
}
