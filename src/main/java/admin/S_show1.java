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
 * Servlet implementation class S_show1
 */
@WebServlet("/S_show1")
public class S_show1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_show1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			   response.setContentType("text/html");
			   PrintWriter out=response.getWriter();
			   String n=request.getParameter("uname");
			   System.out.println(n);
			   String br="";
			   
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from students where s_id='"+n+"'");
			   while(rs.next())
			   {
				 
			   		out.println("<!DOCTYPE html>\r\n"
			   				+ "<html>\r\n"
			   				+ "<head>\r\n"
			   				+ "	<title>Student Detail Slip</title>\r\n"
			   				+ "	<style type=\"text/css\">\r\n"
			   				+ "		body {\r\n"
			   				+ "			font-family: Arial, sans-serif;\r\n"
			   				+ "			background-color: #f2f2f2;\r\n"
			   				+ "		}\r\n"
			   				+ "		.container {\r\n"
			   				+ "			margin: auto;\r\n"
			   				+ "			width: 38%;\r\n"
			   				+ "			background-color: #fff;\r\n"
			   				+ "			padding: 20px;\r\n"
			   				+ "			box-shadow: 0 0 10px rgba(0,0,0,0.3);\r\n"
			   				+ "min-height: 400px;"
			   				+ "		}\r\n"
			   				+ "		h1 {\r\n"
			   				+ "			text-align: center;\r\n"
			   				+ "			font-size: 24px;\r\n"
			   				+ "			margin-top: 0;\r\n"
			   				+ "			color: #333;\r\n"
			   				+ "		}\r\n"
			   				+ "		table {\r\n"
			   				+ "			width: 100%;\r\n"
			   				+ "			border-collapse: collapse;\r\n"
			   				+ "			margin-top: 20px;\r\n"
			   				+ "		}\r\n"
			   				+ "		table td, table th {\r\n"
			   				+ "			padding: 10px;\r\n"
			   				+ "			border: 1px solid #ccc;\r\n"
			   				+ "		}\r\n"
			   				+ "		table th {\r\n"
			   				+ "			background-color: #f5f5f5;\r\n"
			   				+ "			color: #333;\r\n"
			   				+ "		}\r\n"
			   				+ "		.student-photo {\r\n"
			   				+ "			width: 150px;\r\n"
			   				+ "			height: 150px;\r\n"
			   				+ "			margin-right: 20px;\r\n"
			   				+ "			float: left;\r\n"
			   				+ "		}\r\n"
			   				+ "		.student-info {\r\n"
			   				+ "			float: left;\r\n"
			   				+ "			margin-top: 0px;\r\n"
			   				+ "		}\r\n"
			   				+ "		.student-info p {\r\n"
			   				+ "			margin: 0;\r\n"
			   				+ "			line-height: 1.5;\r\n"
			   				+ "		}\r\n"
			   				+ "	</style>\r\n"
			   				+ "</head>\r\n"
			   				+ "<body>\r\n"
			   				+ "	<div class=\"container\">\r\n"
			   				+ "		<h1>Student Detail Slip</h1>\r\n"
			   				+ "		<div class=\"student\">\r\n"
			   				+ "			<img class=\"student-photo\" src=\"https://via.placeholder.com/150\" alt=\"Student Photo\">\r\n"
			   				+ "			<div class=\"student-info\">\r\n"
			   				+ " <table style=\"font-weight: bolder;\">\r\n"
			   				+ "                    <tr>\r\n"
			   				+ "                        <td>ID</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs.getString("s_id")+"</td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                    <tr>\r\n"
			   				+ "                        <td>Name</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs.getString("s_name")+"</td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                    <tr>\r\n"
			   				+ "                        <td>Branch</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs.getString("s_branch")+"</td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                    <tr>\r\n"
			   				+ "                        <td>Email</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs.getString("s_mail")+" </td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                    <tr>\r\n"
			   				+ "                        <td>D.O.B</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs.getString("s_dob")+"</td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                    <tr>\r\n"
			   				+ "                        <td>Gender</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs.getString("s_sex")+"</td>\r\n"
			   				+ "                    </tr> <tr>\r\n"
			   				
			   				+ "                </table>"

			   				+ "			</div>\r\n"
			   				+ "		</div>\r\n"
			   				+ "	</div>\r\n"
			   				+ "</body>\r\n"
			   				+ "</html>");
	}}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}}
				  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
