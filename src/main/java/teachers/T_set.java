package teachers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class T_set
 */
@WebServlet("/T_set")
public class T_set extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_set() {
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
		String pass=request.getParameter("pass");
		String pass1=request.getParameter("pass1");
		PrintWriter out=response.getWriter();
		if(pass.equals(pass1))
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   PreparedStatement stmt=con.prepareStatement("update staff SET s_pass='"+pass+"' where s_id='"+id+"'");
			   int i=stmt.executeUpdate();
			   if(i>0)
			   {
				   response.sendRedirect("T_setting");
//				    String newPage = "Setting";
//				   request.getRequestDispatcher(newPage).forward(request, response);
			   }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
		else
		{	
			try 
			{
				RequestDispatcher rd=request.getRequestDispatcher("T_setting");
				rd.include(request, response);
				out.println("Please check the password once more");  
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
			
		}
	}

}
