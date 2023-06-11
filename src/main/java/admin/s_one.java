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
 * Servlet implementation class s_one
 */
@WebServlet("/s_one")
public class s_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public s_one() {
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
			   String br="";
			   int ttl=0;
			   int ttl1=0;
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from students where s_id='"+n+"'");
			   while(rs.next())
			   {
				  br=rs.getString("s_branch");
				  PreparedStatement stmt1=con.prepareStatement("select maths,edc,java,dc,cse.t_id from CSE INNER JOIN students on CSE.s_id=students.s_id where students.s_id='"+n+"'");
				  ResultSet rs1=stmt1.executeQuery();
				  while(rs1.next())
				  {
				  if(br.equals("CSE"))
				  {
					  ttl=rs1.getInt("cse.maths")+rs1.getInt("cse.edc")+rs1.getInt("cse.java")+rs1.getInt("cse.dc");
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
			   				+ "			width: 50%;\r\n"
			   				+ "			background-color: #fff;\r\n"
			   				+ "			padding: 20px;\r\n"
			   				+ "			box-shadow: 0 0 10px rgba(0,0,0,0.3);\r\n"
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
			   				+ "                        <td>updated Teacher</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs1.getString("cse.t_id")+"</td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                </table>"

			   				+ "			</div>\r\n"
			   				+ "		</div>\r\n"
			   				+ "		<table>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<th>Subject</th>\r\n"
			   				+ "				<th>Marks</th>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>Mathematics</td>\r\n"
			   				+ "				<td>"+rs1.getInt("cse.maths")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>EDC</td>\r\n"
			   				+ "				<td>"+rs1.getInt("cse.edc")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>JAVA</td>\r\n"
			   				+ "				<td>"+rs1.getInt("cse.java")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>DCs</td>\r\n"
			   				+ "				<td>"+rs1.getInt("cse.dc")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"

			   				+ "				<td>Total Marks</td>\r\n"
			   				+ "				<td>"+ttl+"/400</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "		</table>\r\n"
			   				+ "	</div>\r\n"
			   				+ "</body>\r\n"
			   				+ "</html>");
				  } }
				  PreparedStatement stmt2=con.prepareStatement("select math,cad,edc,pom,MECH.t_id from MECH INNER JOIN students on MECH.s_id=students.s_id where students.s_id='"+n+"'");
				  ResultSet rs2=stmt2.executeQuery();
				  while(rs2.next())
				  {
				
				  
				  if(br.equals("MECH"))
				  {
					  ttl1=rs2.getInt("MECH.math")+rs2.getInt("MECH.cad")+rs2.getInt("MECH.edc")+rs2.getInt("MECH.pom");
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
			   				+ "			width: 50%;\r\n"
			   				+ "			background-color: #fff;\r\n"
			   				+ "			padding: 20px;\r\n"
			   				+ "			box-shadow: 0 0 10px rgba(0,0,0,0.3);\r\n"
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
			   				+ "                        <td>updated Teacher</td>\r\n"
			   				+ "                        <td>:</td>\r\n"
			   				+ "                        <td>"+rs1.getString("MECH.t_id")+"</td>\r\n"
			   				+ "                    </tr>\r\n"
			   				+ "                </table>"

			   				+ "			</div>\r\n"
			   				+ "		</div>\r\n"
			   				+ "		<table>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<th>Subject</th>\r\n"
			   				+ "				<th>Marks</th>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>Mathematics</td>\r\n"
			   				+ "				<td>"+rs2.getInt("MECH.math")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>CAD</td>\r\n"
			   				+ "				<td>"+rs2.getInt("MECH.cad")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>EDC</td>\r\n"
			   				+ "				<td>"+rs2.getInt("MECH.edc")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"
			   				+ "				<td>POM</td>\r\n"
			   				+ "				<td>"+rs2.getInt("MECH.pom")+"</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "			<tr>\r\n"

			   				+ "				<td>Total Marks</td>\r\n"
			   				+ "				<td>"+ttl1+"/400</td>\r\n"
			   				+ "			</tr>\r\n"
			   				+ "		</table>\r\n"
			   				+ "	</div>\r\n"
			   				+ "</body>\r\n"
			   				+ "</html>");
				  }
			   
			   
			   }}
		 }catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
