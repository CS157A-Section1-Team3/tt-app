package dept.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dept.model.Department;

public class DepartmentDao { 
	public void showDept(Department department) throws ClassNotFoundException {
		String SHOW_DEPT = "SELECT Users.ID as 'EmployeeID', "
				+ "SUM(hWorked) as 'Total hours worked' " +
				"FROM department, Hours, SHIFT, Users " + 
				"WHERE Department.name = ? AND Users.id = shift.pid " +
				"GROUP BY shift.pid " + 
				"ORDER BY SUM(hWorked);";
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/ttapp?serverTimezone=EST5EDT", "root", "rootroot")){

	         try (PreparedStatement preparedStatement = connection.prepareStatement(SHOW_DEPT)) {
				 preparedStatement.setString(1,department.getDepartment());
				 
				 ResultSet rs = preparedStatement.executeQuery();
				 
				 System.out.println("hours worked ranking");
				 
				 while (rs.next()) {
					 String UserID = rs.getString("EmployeeID");
					 String hWorked = rs.getString("Total hours worked");
					 System.out.println(UserID + "   " + hWorked + "   ");
			 	}
	         } 
		 }  catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	     } 
	            
	}
	
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
	
}
