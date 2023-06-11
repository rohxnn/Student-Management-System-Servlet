package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T_create
 */
@WebServlet("/T_create")
public class T_create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T_create() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        body {\r\n"
				+ "  font-family: Arial, sans-serif;\r\n"
				+ "  margin: 0;\r\n"
				+ "  padding: 0;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".container {\r\n"
				+ "  width: 50%;\r\n"
				+ "  margin: 50px auto;\r\n"
				+ "  padding: 20px;\r\n"
				+ "  border: 1px solid #ccc;\r\n"
				+ "  border-radius: 5px;\r\n"
				+ "  background-color: beige;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "h1 {\r\n"
				+ "  text-align: center;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "form {\r\n"
				+ "  display: flex;\r\n"
				+ "  flex-direction: column;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "label {\r\n"
				+ "  margin-top: 10px;\r\n"
				+ "  margin-bottom: 5px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "input[type=\"text\"],\r\n"
				+ "input[type=\"email\"],\r\n"
				+ "input[type=\"password\"],\r\n"
				+ "textarea {\r\n"
				+ "  padding: 10px;\r\n"
				+ "  border-radius: 5px;\r\n"
				+ "  border: 1px solid #ccc;\r\n"
				+ "  margin-bottom: 15px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "select {\r\n"
				+ "  padding: 10px;\r\n"
				+ "  border-radius: 5px;\r\n"
				+ "  border: 1px solid #ccc;\r\n"
				+ "  margin-bottom: 15px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "input[type=\"submit\"] {\r\n"
				+ "  padding: 10px;\r\n"
				+ "  border-radius: 5px;\r\n"
				+ "  border: none;\r\n"
				+ "  background-color: #4CAF50;\r\n"
				+ "  color: white;\r\n"
				+ "  font-size: 16px;\r\n"
				+ "  cursor: pointer; */\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <h1>Teacher Registration Form</h1>\r\n"
				+ "        <form method=\"post\" action=\"T_reg\">\r\n"
				+ "          <label for=\"name\">Name</label>\r\n"
				+ "          <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Enter your name\">\r\n"
				+ "          <label for=\"password\">Password</label>\r\n"
				+ "          <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Enter your password\">\r\n"
				+ "          <label for=\"Number\">Ph_no</label>\r\n"
				+ "          <input type=\"number\" id=\"number\" name=\"ph_no\" placeholder=\"Enter your phone number\">\r\n"
				+ "  \r\n"
				+ "          <label for=\"email\">Email</label>\r\n"
				+ "          <input type=\"email\" id=\"email\" name=\"email\" placeholder=\"Enter your email\">\r\n"
				+ "          <br><br>\r\n"
				+ "          <div>  \r\n"
				+ "            <label>   \r\n"
				+ "            Course :  \r\n"
				+ "            </label>   \r\n"
				+ "              \r\n"
				+ "            <select name=\"Branch\">  \r\n"
				+ "            <option value=\"Course\">Course</option>  \r\n"
				+ "            <option value=\"CSE\">CSE</option>  \r\n"
				+ "            <option value=\"MECH\">MECH</option>  \r\n"
				+ "          \r\n"
				+ "            </select>  \r\n"
				+ "            </div> \r\n"
				+ "            <label for=\"gender\">Gender</label>\r\n"
				+ "            <select id=\"gender\" name=\"gender\">\r\n"
				+ "              <option value=\"male\">Male</option>\r\n"
				+ "              <option value=\"female\">Female</option>\r\n"
				+ "              <option value=\"other\">Other</option>\r\n"
				+ "            </select> <br><br>\r\n"
				+ "  \r\n"
				+ "          <input type=\"submit\" value=\"Submit\">\r\n"
				+ "          \r\n"
				+ "        </form>\r\n"
				+ "      </div>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
