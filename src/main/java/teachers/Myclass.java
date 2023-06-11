package teachers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Myclass
 */
@WebServlet("/Myclass")
public class Myclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myclass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String t_id=(String)session.getAttribute("uname");
		PrintWriter out=response.getWriter();
		String br="";
		String id="";
		int sc=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			  PreparedStatement stmt=con.prepareStatement("select * from staff where t_id='"+t_id+"'");
			  ResultSet rs=stmt.executeQuery(); 
			  while(rs.next())
			  {
				  br=rs.getString("branch");
				  id=rs.getString("t_id");
			  } 
			  PreparedStatement stmt1=con.prepareStatement("select count(*) from students where s_branch='"+br+"'");
			   ResultSet rs1=stmt1.executeQuery();
			 
			  while(rs1.next())
			   {
				   sc=rs1.getInt("count(*)");
			   }
		 

		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>View classes</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "<style>\r\n"
				+ "    #logo {\r\n"
				+ "            width: 5%;\r\n"
				+ "        }\r\n"
				+ "        .container-fluid\r\n"
				+ "        {\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 0;\r\n"
				+ "\r\n"
				+ "        }\r\n"
				+ "        .head\r\n"
				+ "        {\r\n"
				+ "            width: 100%;\r\n"
				+ "            max-height: 100px;\r\n"
				+ "           \r\n"
				+ "        }\r\n"
				+ "        .hero\r\n"
				+ "{\r\n"
				+ "    width: 100%;\r\n"
				+ "    min-height: 90vh;\r\n"
				+ "    display: flex;\r\n"
				+ "    gap: 90px;\r\n"
				+ "}\r\n"
				+ ".sidebar {\r\n"
				+ "  margin: 0;\r\n"
				+ "  padding: 0;\r\n"
				+ "  width: 200px;\r\n"
				+ "  height: 100%;\r\n"
				+ "  overflow: auto;\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Sidebar links */\r\n"
				+ ".sidebar a {\r\n"
				+ "  display: block;\r\n"
				+ "  color:    rgb(19, 17, 17);\r\n"
				+ "  padding: 16px;\r\n"
				+ "  text-decoration: none;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Active/current link */\r\n"
				+ ".sidebar a.active {\r\n"
				+ "  background-color: #0e1d93;\r\n"
				+ "  color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Links on mouse-over */\r\n"
				+ ".sidebar a:hover:not(.active) {\r\n"
				+ "  background-color: #555;\r\n"
				+ "  color: white;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Page content. The value of the margin-left property should match the value of the sidebar's width property */\r\n"
				+ "div.content {\r\n"
				+ "  margin-left: 200px;\r\n"
				+ "  padding: 1px 16px;\r\n"
				+ "  height: 1000px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* On screens that are less than 700px wide, make the sidebar into a topbar */\r\n"
				+ "@media screen and (max-width: 700px) {\r\n"
				+ "  .sidebar {\r\n"
				+ "    width: 100%;\r\n"
				+ "    height: auto;\r\n"
				+ "    position: relative;\r\n"
				+ "  }\r\n"
				+ "  .sidebar a {float: left;}\r\n"
				+ "  div.content {margin-left: 0;}\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* On screens that are less than 400px, display the bar vertically, instead of horizontally */\r\n"
				+ "@media screen and (max-width: 400px) {\r\n"
				+ "  .sidebar a {\r\n"
				+ "    text-align: center;\r\n"
				+ "    float: none;\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				+ ".content\r\n"
				+ "{\r\n"
				+ "    height: fit-content;\r\n"
				+ "}\r\n"
				+ ".crd:hover\r\n"
				+ "{\r\n"
				+ "    background-color: #eef4f9;\r\n"
				+ "        transition: all 0.3s;\r\n"
				+ "}\r\n"
				+ ".tab\r\n"
				+ "{\r\n"
				+ "    max-width: 100px;\r\n"
				+ "    border: solid black;\r\n"
				+ "    max-height: 300px;\r\n"
				+ "    position: absolute;\r\n"
				+ "    bottom: 40px;\r\n"
				+ "    left: 20%;\r\n"
				+ "}\r\n"
				+ ".ab\r\n"
		  		+ "        {\r\n"
		  		+ "            position: absolute;\r\n"
		  		+ "            bottom: 30px;\r\n"
		  		+ "        }\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "        <div class=\"head\">\r\n"
				+ "            <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\r\n"
				+ "\r\n"
				+ "                    <a class=\"navbar-brand\" href=\"#\">\r\n"
				+ "                        <img src=\"https://user-images.githubusercontent.com/85304015/236447598-07f5334f-318b-4260-bf5b-5eb1e1e4cc65.png\"\r\n"
				+ "                            alt=\"Bootstrap\" id=\"logo\">\r\n"
				+ "        \r\n"
				+ "                    </a>\r\n"
				+ "                       \r\n"
				+ "                   \r\n"
				+ "                    <div style=\"display: flex;\">\r\n"
				+ "                        <h4 style=\"width: 164px;\">Hello "+id+"</h4>\r\n"
				+ "                       <img src=\"https://user-images.githubusercontent.com/85304015/240564369-ce187ba1-2052-443c-be1b-c98de3dbee2c.png\"\r\n"
				+ "                            alt=\"\" width=\"44\" height=\"44\">\r\n"
				+ "                    </div>\r\n"
				+ "            </nav>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"hero\">\r\n"
				+ "            <div class=\"sidebar\">\r\n"
				+ "                <a  href=\"T_log\"><b>Dashboard</b> </a>\r\n"
				+ "                <a class=\"active\" href=\"Myclass\"><b> My Classes</b></a>\r\n"
				+ "                <a href=\"#dd\"><b>Team Plans</b> </a>\r\n"
				+ "                <a href=\"T_setting\"><b>Settings</b> </a>\r\n"
				+ "                <div> <a class=\"ab\" href=\"A_logout\"><b>Logout</b> </a></div>\r\n"
				+ "               \r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"card bg-light mb-3 \" style=\"max-width: 18rem; height: 200px;\">\r\n"
				+ "                <div style=\"height: 100px;\" class=\"card-body crd\">\r\n"
				+ "                  <h5 class=\"card-title\">Total no. of students</h5>\r\n"
				+ "                  <h1 class=\"card-text\">"+sc+"</h1>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "              <div class=\"card bg-light mb-3 \" style=\"max-width: 18rem; height: 200px;\">\r\n"
				+ "                <div class=\"card-body crd\">\r\n"
				+ "                  <h5 class=\"card-title\">Toppest students</h5>\r\n"
				+ "                  <h1 class=\"card-text\">.</h1>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "              <div class=\"card crd\" style=\"width: 24rem; height: fit-content;\">\r\n"
				+ "                <img src=\"https://img.freepik.com/premium-photo/group-happy-young-students-university_85574-4531.jpg?w=2000\" class=\"card-img-top\" alt=\"Students\" width=\"100%\">\r\n"
				+ "                <div class=\"card-body\">\r\n"
				+ "                  <h5 class=\"card-title\">Create Student</h5>\r\n"
				+ "                  <p class=\"card-text\">Click on the below button to create a student</p>\r\n"
				+ "                  <a href=\"S_create\" class=\"btn btn-primary\">Create Student</a>\r\n"
				+ "                </div>\r\n"
				+ "                </div>\r\n"
				+ "                    <div class=\"tab\">\r\n"
				+ "    <table class=\"table table-striped tab\">\r\n"
		   		+ "        <thead>\r\n"
		   		+ "          <tr>\r\n"
		   		+ "           \r\n"
		   		+ "            <th scope=\"col\">ID</th>\r\n"
		   		+ "            <th scope=\"col\">NAME</th>\r\n"
		   		+ "            <th scope=\"col\">BRANCH</th>\r\n"
		   		+ "           \r\n"
		   		+ "          </tr>\r\n"
		   		+ "        </thead>\r\n");
					PreparedStatement stmt2=con.prepareStatement("select s_id,s_name,s_branch from students where s_branch='"+br+"'");
					ResultSet rs2=stmt2.executeQuery();
					while(rs2.next())
					{
						  out.println(" <tbody>\r\n"
							   		+ "                <tr>\r\n"
							   		+ "\r\n"
							   		+ "                  <td>"+rs2.getString("s_id")+"</td>\r\n"
							   		+ "                  <td>"+rs2.getString("s_name")+"</td>\r\n"
							   		+ "                  <td>"+rs2.getString("s_branch")+"</td>\r\n"
							   		+ "  				 <td><a href='s_one?uname="+rs2.getString("s_id")+"'><button class=\"btn btn-success\">view</button></a></td>"		
							   		+ "  				 <td><a href='Up_mark?uname="+rs2.getString("s_id")+"'><button class=\"btn btn-success\">Update</button></a></td>"				
							   		+ "                  <td><a href='S_del?uname="+rs2.getString("s_id")+"'><button class=\"btn btn-danger\">Delete</button></td>\r\n"
							   		+ "                </tr>\r\n"
							   		+ "                </tbody>"
							   		+ "                    </div>\r\n"
									+ "              </div>\r\n"
									+ "</body>\r\n"
									+ "</html>");
					
					}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
