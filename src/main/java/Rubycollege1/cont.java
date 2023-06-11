package Rubycollege1;

import java.sql.*;

public class cont {
	static Connection con;
	static void contt()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ruby","root","root");
		} catch (Exception e) {
			// TODO: handle exception
//			throw new RuntimeException("unhandled", e);
			System.out.println(e);
		
		}
	}

}
