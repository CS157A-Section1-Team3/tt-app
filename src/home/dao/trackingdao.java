package home.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import home.model.tracking;

public class trackingdao {
	 public int enterHours(tracking tracking) throws ClassNotFoundException {
	        String INSERT_SHIFT_SQL = "INSERT INTO SHIFT" + 
	        		"(Start,End,PID) VALUES"+
	        		"(?,?,?);";
	        String INSERT_HOURS_SQL = "INSERT INTO Hours" + 
	        		"(UID,hWorked) VALUES" +
	        		"(SELECT ID FROM USERS WHERE username = ? ,"
	        		+ "SELECT TIMEDIFF(end,start) FROM SHIFT where id = (SELECT ID FROM Users WHERE Username =? );";
	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/ttapp?serverTimezone=EST5EDT", "root", "rootroot")){
	        	//get start/end/pid for shift table and insert into them
	            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHIFT_SQL)) {
	            	preparedStatement.setString(1, tracking.getStart());
		            preparedStatement.setString(2, tracking.getEnd());
		            preparedStatement.setString(3, tracking.getPID());
	            	preparedStatement.executeUpdate();
	            }
	            /*shift id will be same (AI),get UID and put in calculated hours into 
	            Hours table*/
	            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOURS_SQL)) {      
	            
	            	//grab username via html variable passing
	            	preparedStatement.setString(1, tracking.getTeam());
	            	preparedStatement.setString(2, tracking.getUsername());
		            //make sure the same UID gets input into hWorked query.
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            System.out.println(preparedStatement);
	            	result = preparedStatement.executeUpdate();
	            }

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        System.out.println("enterHour form working?");
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
