package dept.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dept.model.Department;

public class DepartmentDao { 
	public static void showDept(Department department) throws ClassNotFoundException {
		String SHOW_DEPT = "SELECT SUM(hWorked) " +
				"FROM department, Hours, SHIFT " + 
				"WHERE Department.name = ? " +
				"GROUP BY department.name " + 
				"ORDER BY SUM(hWorked);";
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/ttapp?serverTimezone=EST5EDT", "root", "rootroot")){

	         try (PreparedStatement preparedStatement = connection.prepareStatement(SHOW_DEPT)) {
			 preparedStatement.setString(1,Department.getDepartment());
			 ResultSet rs = preparedStatement.executeQuery(SHOW_DEPT);
			 
			 System.out.println("hours worked ranking");
			 
			 	while (rs.next()) {
				
				 String hWorked = rs.getString("hours");
				 System.out.println(hWorked + "   ");
			 	}
	         } 
		 }   catch (SQLException e) {
	            // process sql exception
			 System.out.println("SQL exception occured" + e);
		 }
	            
	}
}
