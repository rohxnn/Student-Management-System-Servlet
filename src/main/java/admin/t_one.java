package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class t_one
 */
@WebServlet("/t_one")
public class t_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public t_one() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		try {
			   response.setContentType("text/html");
			   PrintWriter out=response.getWriter();
			   String n=request.getParameter("uname");
			   System.out.println(n);
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from staff where t_id='"+n+"'");
			   
			   
			   out.println("<!DOCTYPE html>\r\n"
			   		+ "<html lang=\"en\">\r\n"
			   		+ "<head>\r\n"
			   		+ "    <meta charset=\"UTF-8\">\r\n"
			   		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
			   		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			   		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
			   		+ "    <style>\r\n"
			   		+ "        h1{\r\n"
			   		+ "            text-align: center;\r\n"
			   		+ "        }\r\n"
			   		+ "        .title\r\n"
			   		+ "        {\r\n"
			   		+ "            font-weight: bold;\r\n"
			   		+ "            width: 30%;\r\n"
			   		+ "         position: absolute;\r\n"
			   		+ "        top: 33%;\r\n"
			   		+ "        }\r\n"
			   		+ "        .semicol\r\n"
			   		+ "        {\r\n"
			   		+ "            width: 30%;\r\n"
			   		+ "            position: absolute;\r\n"
			   		+ "        top: 33%;\r\n"
			   		+ "        left: 50%;\r\n"
			   		+ "        font-weight: bold;\r\n"
			   		+ "        }\r\n"
			   		+ "        .context\r\n"
			   		+ "        {\r\n"
			   		+ "            width: 30%;\r\n"
			   		+ "            position: absolute;\r\n"
			   		+ "        top: 33%;\r\n"
			   		+ "        left: 51%;\r\n"
			   		+ "        font-weight: bold;\r\n"
			   		+ "        }\r\n"
			   		+ "        .container\r\n"
			   		+ "        {\r\n"
			   		+ "            height: fit-content;\r\n"
			   		+ "        }\r\n"
			   		+ "    </style>\r\n"
			   		+ "    <title>Document</title>\r\n"
			   		+ "</head>\r\n"
			   		+ "<body>\r\n"
			   		+ "        <h1><u></u>Staff Detail</h1>\r\n"
			   		+ "        <div class=\"container\">\r\n"
			   		+ "            <div class=\"title\">\r\n"
			   		+ "                <p>ID</p>\r\n"
			   		+ "                <p>NAME</p>\r\n"
			   		+ "                <p>PASSWORD</p>\r\n"
			   		+ "                <p>EMAIL</p>\r\n"
			   		+ "                <p>NUMBER</p>\r\n"
			   		+ "                <p>BRANCH</p>\r\n"
			   		+ "                <p>GENDER</p>\r\n"
			   		+ "            </div>\r\n"
			   		+ "            <div class=\"semicol\">\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "                <p>:</p>\r\n"
			   		+ "            </div>\r\n");
			   		while(rs.next())
			   		{
			   			
			   	
			   		out.println("            <div class=\"context\">\r\n"
			   		+ "                <p>"+rs.getString("t_id")+"</p>\r\n"
			   		+ "                <p>"+rs.getString("t_name")+"</p>\r\n"
			   		+ "                <p>"+rs.getString("t_pass")+"</p>\r\n"
			   		+ "                <p>"+rs.getString("t_email")+"</p>\r\n"
			   		+ "                <p>"+rs.getInt("t_no")+"</p>\r\n"
			   		+ "                <p>"+rs.getString("branch")+"</p>\r\n"
			   		+ "                <p>"+rs.getString("sex")+"</p>\r\n"
			   		+ "            </div>\r\n"
			   		+ "        </div>\r\n"
			   		+ "        \r\n"
			   		+ "    \r\n"
			   		+ "</body>\r\n"
			   		+ "</html>");
			   		}
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
