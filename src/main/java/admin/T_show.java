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
 * Servlet implementation class T_show
 */
@WebServlet("/T_show")
public class T_show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from staff");
			   out.println("<!DOCTYPE html>\r\n"
			   		+ "<html lang=\"en\">\r\n"
			   		+ "<head>\r\n"
			   		+ "    <meta charset=\"UTF-8\">\r\n"
			   		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
			   		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
			   		+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
			   		+ "\r\n"
			   		+ "    <title>Show staff</title>\r\n"
			   		+ "    <style>\r\n"
			   		+ "        .tab\r\n"
			   		+ "        {\r\n"
			   		+ "            width: 64%;\r\n"
			   		+ "        position: absolute;\r\n"
			   		+ "         left: 20%;\r\n"
			   		+ "        top: 20%;\r\n"
			   		+ "        }\r\n"
			   		+ "  #logo {\r\n"
			   		+ "            width: 5%;\r\n"
			   		+ "        }"
			   		
			   		+ "\r\n"
			   		+ "    </style>\r\n"
			   		+ "</head>\r\n"
			   		+ "<body>\r\n"
			   		+ " <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\r\n"
			   		+ "        <div class=\"container-fluid\">\r\n"
			   		+ "\r\n"
			   		+ "            <a class=\"navbar-brand\" href=\"#\">\r\n"
			   		+ "                <img src=\"https://user-images.githubusercontent.com/85304015/236447598-07f5334f-318b-4260-bf5b-5eb1e1e4cc65.png\"\r\n"
			   		+ "                    alt=\"Bootstrap\" id=\"logo\">\r\n"
			   		+ "\r\n"
			   		+ "            </a>\r\n"
			   		+ "            <div style=\"display: flex;\">\r\n"
			   		+ " <input class=\"form-control ab\" id=\"myInput\" type=\"text\" placeholder=\"Search..\">"
			   		+ " <button style=\"color: white;\" type=\"button\" class=\"btn btn-primary\"><a  class=\"nav-link\" href=\"T_create\">Create Teacher</a></button>"
			   		+ "            </div>\r\n"
			   		+ "        </div>\r\n"
			   		+ "    </nav>"
			   		
			   
			   		+ "    <table style=\"background-color: powderblue; border: solid lightblue;\" class=\"table table-striped tab\" >\r\n"
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
				   out.println(" <tbody  id=\"myTable\" >\r\n"
				   		+ "                <tr>\r\n"
				   		+ "\r\n"
				   		+ "                  <td>"+rs.getString("t_id")+"</td>\r\n"
				   		+ "                  <td>"+rs.getString("t_name")+"</td>\r\n"
				   		+ "  				 <td><a href='t_one?uname="+rs.getString("t_id")+"'><button class=\"btn btn-success\">view</button></a></td>"						
				   		+ "                  <td><a href='T_del?uname="+rs.getString("t_id")+"'<button class=\"btn btn-danger\">Delete</button></td>\r\n"
				   		+ "                </tr>\r\n"
				   		+ "                </tbody>"
				   		+ " <script>\r\n"
				   		+ "        $(document).ready(function(){\r\n"
				   		+ "          $(\"#myInput\").on(\"keyup\", function() {\r\n"
				   		+ "            var value = $(this).val().toLowerCase();\r\n"
				   		+ "            $(\"#myTable tr\").filter(function() {\r\n"
				   		+ "              $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)\r\n"
				   		+ "            });\r\n"
				   		+ "          });\r\n"
				   		+ "        });\r\n"
				   		+ "        </script>");
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
		
	}

}
