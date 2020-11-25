package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import registration.model.Employee;

public class EmployeeDao {

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO USERS " + 
        		"(username,password,departmentID) VALUES"+
        		"(?,?,?);";
        String INSERT_POS_SQL = "INSERT INTO POSITION " + 
        		"(departmentID,position) VALUES" +
        		"(?,?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:3306/ttapp?serverTimezone=EST5EDT", "root", "rootroot")){

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            	preparedStatement.setString(1, employee.getUsername());
	            preparedStatement.setString(2, employee.getPassword());
	            preparedStatement.setString(3, employee.getDepartmentID());
            	preparedStatement.executeUpdate();
            }
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POS_SQL)) {      
            
	          
	            preparedStatement.setString(1, employee.getDepartmentID());
	            preparedStatement.setString(2, employee.getPosition());
	
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
            	result = preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
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