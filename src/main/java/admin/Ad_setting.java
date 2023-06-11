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
 * Servlet implementation class Ad_setting
 */
@WebServlet("/Ad_setting")
public class Ad_setting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ad_setting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select * from admin");
			   while(rs.next())
			   {
				   out.println("<!DOCTYPE html>\r\n"
				   		+ "<html lang=\"en\">\r\n"
				   		+ "<head>\r\n"
				   		+ "    <meta charset=\"UTF-8\">\r\n"
				   		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				   		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				   		+ "    <title>Setting</title>\r\n"
				   		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
				   		+ " <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>"
				   		+ "    <style>\r\n"
				   		+ "          #logo {\r\n"
				   		+ "            width: 5%;\r\n"
				   		+ "        }\r\n"
				   		+ "        .container-fluid\r\n"
				   		+ "        {\r\n"
				   		+ "            margin: 0;\r\n"
				   		+ "            padding: 0;\r\n"
				   		+ "        }\r\n"
				   		+ "        .pro\r\n"
				   		+ "        {\r\n"
				   		+ "            border: black;\r\n"
				   		+ "            border-style: ridge;\r\n"
				   		+ "\r\n"
				   		+ "    width: 30%;\r\n"
				   		+ "    height: fit-content;\r\n"
				   		+ "    position: relative;\r\n"
				   		+ "    left: 100px;\r\n"
				   		+ "    top: 50px;\r\n"
				   		+ "    color: blue;\r\n"
				   		+ "    font-family: Arial, Helvetica, sans-serif;\r\n"
				   		+ "        }\r\n"
				   		+ "        p{\r\n"
				   		+ "            font-size: 30px;\r\n"
				   		+ "        }\r\n"
				   		+ "        body{\r\n"
				   		+ "            background-color: whitesmoke;\r\n"
				   		+ "        }\r\n"
				   		+ " .but"
				   		+ "{"
				   		+ "position: absolute;\r\n"
				   		+ "    right: 50px;\r\n"
				   		+ "    top: 100px;"
				   		+ "}"
				   		+ "    </style>\r\n"
				   		+ "</head>\r\n"
				   		+ "<body>\r\n"
				   		+ "    <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\r\n"
				   		+ "        <div class=\"container-fluid \">\r\n"
				   		+ "            <div>\r\n"
				   		+ "            <a class=\"navbar-brand\" href=\"#\">\r\n"
				   		+ "                <img src=\"https://user-images.githubusercontent.com/85304015/236447598-07f5334f-318b-4260-bf5b-5eb1e1e4cc65.png\"\r\n"
				   		+ "                    alt=\"Bootstrap\" id=\"logo\">\r\n"
				   		+ "\r\n"
				   		+ "            </a>\r\n"
				   		+ "        </div>\r\n"
				   		+ "    </nav>\r\n"
				   		+ "        <div class=\"pro\">\r\n"
				   		+ "            <h1 style=\"text-align: center; font-weight: bolder;\"><u>Profile</u></h1>\r\n"
				   		+ "            <br>\r\n"
				   		+ "            <br>\r\n"
				   		+ "            <p>Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:"+rs.getString("A_id")+"</p>\r\n"
				   		+ "            <p>Password&nbsp;:"+rs.getString("A_pass")+"</p>\r\n"
				   		+ "        </div>\r\n"
				   		+ "        <div class=\"but\">\r\n"
				   		+ "<div class=\"dropdown\">\r\n"
						+ "        <button type=\"button\" class=\"btn btn-primary dropdown-toggle\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\" data-bs-auto-close=\"outside\">\r\n"
						+ "          Change Password\r\n"
						+ "        </button>\r\n"
						+ "        <form class=\"dropdown-menu p-4\" method=\"post\" action=\"Adminpass\">\r\n"
						+ "          <div class=\"mb-3\">\r\n"
						+ "            <label for=\"exampleDropdownFormPassword2\" class=\"form-label\"> New Password</label>\r\n"
						+ "            <input type=\"password\" class=\"form-control\" id=\"exampleDropdownFormPassword2\" placeholder=\"Password\" name=\"adpass\">\r\n"
						+ "          </div>\r\n"
						+ "          <div class=\"mb-3\">\r\n"
						+ "            <div class=\"form-check\">\r\n"
						+ "              <input type=\"checkbox\" class=\"form-check-input\" id=\"dropdownCheck2\">\r\n"
						+ "              <label class=\"form-check-label\" for=\"dropdownCheck2\">\r\n"
						+ "                Remember me\r\n"
						+ "              </label>\r\n"
						+ "            </div>\r\n"
						+ "          </div>\r\n"
						+ "          <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n"
						+ "        </form>\r\n"
						+ "      </div>"
				   		+ "           \r\n"
				   		+ "        </div>\r\n"
				   		+ "        </div>\r\n"
				   		+ "      \r\n"
				   		+ "</body>\r\n"
				   		+ "</html>");
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
