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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class S_reg
 */
@WebServlet("/S_reg")
public class S_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String id=(String)session.getAttribute("uname");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String sex=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String course=request.getParameter("course");
		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			    Statement stmt1=con.createStatement();
			    ResultSet rs=stmt1.executeQuery("select count(*) from students");
			    int c=0;
			    while(rs.next())
			    {
			    	c=rs.getInt("count(*)");
			    }
			    c++;
			   
			   
			   PreparedStatement stmt=con.prepareStatement("insert into students (s_id,s_name,s_pass,s_mail,s_dob,s_branch,s_sex) values('rby_"+c+"','"+name+"','"+pass+"','"+email+"','"+dob+"','"+course+"','"+sex+"')");
			   int i=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		if(id.equals("r_admin"))
		{
		response.sendRedirect("Ad_back");}
		else
		{
			response.sendRedirect("Myclass");
		}
		
	}}


