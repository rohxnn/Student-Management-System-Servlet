package teachers;

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
 * Servlet implementation class U_mark
 */
@WebServlet("/U_mark")
public class U_mark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public U_mark() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String t_id=request.getParameter("t_id");
		String s_id=request.getParameter("s_id");
		String maths=request.getParameter("maths");
		String edc=request.getParameter("edc");
		String java=request.getParameter("java");
		String dc=request.getParameter("dc");
		String math=request.getParameter("math");
		String cad=request.getParameter("cad");
		String edc1=request.getParameter("edc1");
		String pom=request.getParameter("pom");
		String br="";
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select s_branch from students where s_id='"+s_id+"'");
			   while(rs.next())
			   {
				   br=rs.getString("s_branch");
			   }
			   if(br.equals("CSE"))
			   {
				   PreparedStatement stmt1=con.prepareStatement("insert into CSE(s_id,t_id,maths,edc,java,dc) values('"+s_id+"','"+t_id+"','"+maths+"','"+edc+"','"+java+"','"+dc+"')");
				   int i=stmt1.executeUpdate();
				   response.sendRedirect("Myclass");
			   }
			   if(br.equals("MECH"))
			   {
				   PreparedStatement stmt2=con.prepareStatement("insert into MECH(s_id,t_id,math,cad,edc,pom) values('"+s_id+"','"+t_id+"','"+math+"','"+cad+"','"+edc1+"','"+pom+"')");
				   int i=stmt2.executeUpdate();
				   response.sendRedirect("Myclass");
			   }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

}
