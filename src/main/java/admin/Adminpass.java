package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminpass
 */
@WebServlet("/Adminpass")
public class Adminpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminpass() {
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
		String pass=request.getParameter("adpass");
		
	try {
		 Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
		   PreparedStatement stmt=con.prepareStatement("update admin set t_pass='"+pass+"' where t_id='r_admin'");
		   int i=stmt.executeUpdate();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
	RequestDispatcher rd=request.getRequestDispatcher("staff.html");
	rd.forward(request, response);

	}

}
