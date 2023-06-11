package students;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class S_res
 */
@WebServlet("/S_res")
public class S_res extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_res() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		String s_id=(String)session.getAttribute("uname"); 
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n"
				+ "    <title>Result</title>\r\n"
				+ "    <style>\r\n"
				+ "        .container-fluid {\r\n"
				+ "            padding: 0;\r\n"
				+ "            margin: 0;\r\n"
				+ "            min-height: fit-content;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        #logo {\r\n"
				+ "            width: 70px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .header {\r\n"
				+ "            width: 100%;\r\n"
				+ "            height: fit-content;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .hero {\r\n"
				+ "            width: 100%;\r\n"
				+ "            height: 90vh;\r\n"
				+ "            display: flex;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .sidebar {\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 0;\r\n"
				+ "            width: 13%;\r\n"
				+ "            height: 100%;\r\n"
				+ "            overflow: auto;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .content1 {\r\n"
				+ "            width: 87%;\r\n"
				+ "            background-color: #F0F0F0;\r\n"
				+ "            max-height: max-content;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .sidebar a {\r\n"
				+ "            display: block;\r\n"
				+ "            color: rgb(19, 17, 17);\r\n"
				+ "            padding: 16px;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Active/current link */\r\n"
				+ "        .sidebar a.active {\r\n"
				+ "            background-color: #0e1d93;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Links on mouse-over */\r\n"
				+ "        .sidebar a:hover:not(.active) {\r\n"
				+ "            background-color: #555;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Page content. The value of the margin-left property should match the value of the sidebar's width property */\r\n"
				+ "        div.content {\r\n"
				+ "            margin-left: 200px;\r\n"
				+ "            padding: 1px 16px;\r\n"
				+ "            height: 1000px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* On screens that are less than 700px wide, make the sidebar into a topbar */\r\n"
				+ "        @media screen and (max-width: 700px) {\r\n"
				+ "            .sidebar {\r\n"
				+ "                width: 100%;\r\n"
				+ "                height: auto;\r\n"
				+ "                position: relative;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            .sidebar a {\r\n"
				+ "                float: left;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            div.content {\r\n"
				+ "                margin-left: 0;\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* On screens that are less than 400px, display the bar vertically, instead of horizontally */\r\n"
				+ "        @media screen and (max-width: 400px) {\r\n"
				+ "            .sidebar a {\r\n"
				+ "                text-align: center;\r\n"
				+ "                float: none;\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Responsive styles for header and logo */\r\n"
				+ "        @media screen and (max-width: 768px) {\r\n"
				+ "            .header {\r\n"
				+ "                flex-direction: column;\r\n"
				+ "                align-items: center;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            #logo {\r\n"
				+ "                margin-bottom: 10px;\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Responsive styles for profile card */\r\n"
				+ "        @media screen and (max-width: 768px) {\r\n"
				+ "            .card-body {\r\n"
				+ "                flex-direction: column;\r\n"
				+ "                align-items: center;\r\n"
				+ "            }\r\n"
				+ "\r\n"
				+ "            #profile {\r\n"
				+ "                margin-bottom: 10px;\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "        <div style=\"display: flex; justify-content: space-between;\"  class=\"header\">\r\n"
				+ "            <div>\r\n"
				+ "            <img src=\"https://user-images.githubusercontent.com/85304015/236447598-07f5334f-318b-4260-bf5b-5eb1e1e4cc65.png\"\r\n"
				+ "            alt=\"Bootstrap\" id=\"logo\">\r\n"
				+ "            </div>\r\n"
				+ "            <div style=\"display: flex;\">\r\n"
				+ "                <h4 style=\"width: 164px;\">Hello "+s_id+"</h4>\r\n"
				+ "                <img src=\"https://user-images.githubusercontent.com/85304015/240564369-ce187ba1-2052-443c-be1b-c98de3dbee2c.png\"\r\n"
				+ "                     alt=\"\" width=\"44\" height=\"44\">\r\n"
				+ "                     <h1 style=\"color: aliceblue;\"></h1>\r\n"
				+ "            </div> \r\n"
				+ "        </div>\r\n"
				+ "        <br>\r\n"
				+ "        <div class=\"hero\">\r\n"
				+ "            <div class=\"sidebar\">\r\n"
				+ "                <a  href=\"S_log\"><b>Dashboard</b> </a>\r\n"
				+ "                <a class=\"active\" href=\"S_res\"><b> Result</b></a>\r\n"
				+ "                <a href=\"#contact\"><b>S.M.S</b> </a>\r\n"
				+ "                <a href=\"Setting\"><b>Settings</b> </a>\r\n"
				+ "                <div> <a class=\"ab\" href=\"#about\"><b>Logout</b> </a></div>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"content1\">\r\n");
		try {
			
			RequestDispatcher rd=request.getRequestDispatcher("S_view");
			rd.include(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
					
				out.println("   </div>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>");
	}
				

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
