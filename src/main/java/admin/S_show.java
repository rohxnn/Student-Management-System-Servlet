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
 * Servlet implementation class S_show
 */
@WebServlet("/S_show")
public class S_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from students");
			   out.println("<!DOCTYPE html>\r\n"
			   		+ "<html lang=\"en\">\r\n"
			   		+ "<head>\r\n"
			   		+ "    <meta charset=\"UTF-8\">\r\n"
			   		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
			   		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			   		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
			   		+ "\r\n"
			   		+ "    <title>Show student</title>\r\n"
			   		+ "    <style>\r\n"
			   		+ "        .tab\r\n"
			   		+ "        {\r\n"
			   		+ "            width: 64%;\r\n"
			   		+ "        position: absolute;\r\n"
			   		+ "         left: 20%;\r\n"
			   		+ "        top: 20%;\r\n"
			   		+ "        }\r\n"
			   		+ "\r\n"
			   		+ "    </style>\r\n"
			   		+ "</head>\r\n"
			   		+ "<body>\r\n"
			   		+ "    <table class=\"table table-striped tab\">\r\n"
			   		+ "        <thead>\r\n"
			   		+ "          <tr>\r\n"
			   		+ "           \r\n"
			   		+ "            <th scope=\"col\">ID</th>\r\n"
			   		+ "            <th scope=\"col\">NAME</th>\r\n"
			   		+ "           \r\n"
			   		+ "          </tr>\r\n"
			   		+ "        </thead>\r\n");
			   while(rs.next())
			   {
				   out.println(" <tbody>\r\n"
				   		+ "                <tr>\r\n"
				   		+ "\r\n"
				   		+ "                  <td>"+rs.getString("s_id")+"</td>\r\n"
				   		+ "                  <td>"+rs.getString("s_name")+"</td>\r\n"
				   		+ "  				 <td><a href='S_show1?uname="+rs.getString("s_id")+"'><button class=\"btn btn-success\">view</button></a></td>"				
				   		
				   		+ "                  <td><a href='S_del?uname="+rs.getString("s_id")+"'><button class=\"btn btn-danger\">Delete</button></td>\r\n"
				   		+ "                </tr>\r\n"
				   		+ "                </tbody>");
			   }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
