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
 * Servlet implementation class Up_mark
 */
@WebServlet("/Up_mark")
public class Up_mark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Up_mark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String n=request.getParameter("uname");
		System.out.println(n);
		HttpSession session=request.getSession(false);
		String t_id=(String)session.getAttribute("uname");
		System.out.println(t_id);
		String br="";
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
			   Statement stmt=con.createStatement();
			   ResultSet rs=stmt.executeQuery("select s_branch from students");
			   while(rs.next())
			   {
				   br=rs.getString("s_branch");
			   }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		if(br.equals("CSE"))
		{
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "  <title>Student Marklist</title>\r\n"
				+ "  <style>\r\n"
				+ "    body {\r\n"
				+ "      font-family: Arial, sans-serif;\r\n"
				+ "      background-color: #f2f2f2;\r\n"
				+ "      padding: 20px;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    h1 {\r\n"
				+ "      text-align: center;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    form {\r\n"
				+ "      max-width: 400px;\r\n"
				+ "      margin: 0 auto;\r\n"
				+ "      background-color: #fff;\r\n"
				+ "      padding: 20px;\r\n"
				+ "      border-radius: 5px;\r\n"
				+ "      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    label {\r\n"
				+ "      display: block;\r\n"
				+ "      margin-bottom: 10px;\r\n"
				+ "      font-weight: bold;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    input[type=\"text\"],\r\n"
				+ "    input[type=\"number\"] {\r\n"
				+ "      width: 100%;\r\n"
				+ "      padding: 8px;\r\n"
				+ "      border-radius: 3px;\r\n"
				+ "      border: 1px solid #ccc;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    input[type=\"submit\"] {\r\n"
				+ "      background-color: #4CAF50;\r\n"
				+ "      color: #fff;\r\n"
				+ "      border: none;\r\n"
				+ "      padding: 10px 20px;\r\n"
				+ "      cursor: pointer;\r\n"
				+ "      border-radius: 3px;\r\n"
				+ "    }\r\n"
				+ "    \r\n"
				+ "    input[type=\"submit\"]:hover {\r\n"
				+ "      background-color: #45a049;\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "  <h1>Student Marklist</h1>\r\n"
				+ "  <form method=\"post\" action=\"U_mark\">\r\n"
				+ "<input type=\"hidden\" name=\"t_id\" value=\'"+t_id+"'\">\r\n"
				+ "                    <input type=\"hidden\" name=\"s_id\" value=\'"+n+"'\">"
				+ "    <label for=\"maths\">Maths:</label>\r\n"
				+ "    <input type=\"number\" id=\"maths\" name=\"maths\" required>\r\n"
				+ "    \r\n"
				+ "    <label for=\"edc\">electronics:</label>\r\n"
				+ "    <input type=\"number\" id=\"edc\" name=\"edc\" required>\r\n"
				+ "    \r\n"
				+ "    <label for=\"java\">Java:</label>\r\n"
				+ "    <input type=\"number\" id=\"java\" name=\"java\" required>\r\n"
				+ "    \r\n"
				+ "    <label for=\"dc\">Data communication:</label>\r\n"
				+ "    <input type=\"number\" id=\"dc\" name=\"dc\" required>\r\n"
				+ "    \r\n"
				+ "    <input type=\"submit\" value=\"Submit\">\r\n"
				+ "  </form>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		
	}
		if(br.equals("MECH"))
			{
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "  <title>Student Marklist</title>\r\n"
					+ "  <style>\r\n"
					+ "    body {\r\n"
					+ "      font-family: Arial, sans-serif;\r\n"
					+ "      background-color: #f2f2f2;\r\n"
					+ "      padding: 20px;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    h1 {\r\n"
					+ "      text-align: center;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    form {\r\n"
					+ "      max-width: 400px;\r\n"
					+ "      margin: 0 auto;\r\n"
					+ "      background-color: #fff;\r\n"
					+ "      padding: 20px;\r\n"
					+ "      border-radius: 5px;\r\n"
					+ "      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    label {\r\n"
					+ "      display: block;\r\n"
					+ "      margin-bottom: 10px;\r\n"
					+ "      font-weight: bold;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    input[type=\"text\"],\r\n"
					+ "    input[type=\"number\"] {\r\n"
					+ "      width: 100%;\r\n"
					+ "      padding: 8px;\r\n"
					+ "      border-radius: 3px;\r\n"
					+ "      border: 1px solid #ccc;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    input[type=\"submit\"] {\r\n"
					+ "      background-color: #4CAF50;\r\n"
					+ "      color: #fff;\r\n"
					+ "      border: none;\r\n"
					+ "      padding: 10px 20px;\r\n"
					+ "      cursor: pointer;\r\n"
					+ "      border-radius: 3px;\r\n"
					+ "    }\r\n"
					+ "    \r\n"
					+ "    input[type=\"submit\"]:hover {\r\n"
					+ "      background-color: #45a049;\r\n"
					+ "    }\r\n"
					+ "  </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "  <h1>Student Marklist</h1>\r\n"
					+ "  <form method=\"post\" action=\"U_mark\">\r\n"
					+ "    <input type=\"hidden\" name=\"t_id\" value=\'"+t_id+"'\">\r\n"
					+ "                    <input type=\"hidden\" name=\"s_id\" value=\'"+n+"'\">\r\n"
					+ "    <label for=\"maths\">Maths:</label>\r\n"
					+ "    <input type=\"number\" id=\"maths\" name=\"math\" required>\r\n"
					+ "    \r\n"
					+ "    <label for=\"cad\">CAD:</label>\r\n"
					+ "    <input type=\"number\" id=\"cad\" name=\"cad\" required>\r\n"
					+ "    \r\n"
					+ "    <label for=\"edc\">EDC:</label>\r\n"
					+ "    <input type=\"number\" id=\"edc1\" name=\"edc1\" required>\r\n"
					+ "    \r\n"
					+ "    <label for=\"pom\">POM:</label>\r\n"
					+ "    <input type=\"number\" id=\"pom\" name=\"pom\" required>\r\n"
					+ "    \r\n"
					+ "    <input type=\"submit\" value=\"Submit\">\r\n"
					+ "  </form>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
			}
			}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
