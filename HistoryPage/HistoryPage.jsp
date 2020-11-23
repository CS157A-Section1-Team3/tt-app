<%@ page import="java.sql.*"%>
<html>
  <head>
    <title>JDBC Connection example</title>
    </head>
  <body>
    <h1>JDBC Connection example</h1>

    <table border="1">
      <tr>
        <td>Shift_ID</td>
        <td>Project_ID</td>
        <td>Start_Time</td>
        <td>End_Time</td>
   </tr>
    <%
     String db = "Time";
        String user; // assumes database name is the same as username
          user = "root";
        String password = "71020900";
        try {

            java.sql.Connection con;
             Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Time?serverTimezone=EST5EDT",user, password);
            out.println(db + " database successfully opened.<br/><br/>");

            out.println("Initial entries in table SHIFT: <br/>");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Time.SHIFT");
            while (rs.next()) {
                out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + "<br/><br/>");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch(SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
        }
    %>
  </body>
</html>
