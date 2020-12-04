<%@ page import="java.sql.*"%>
<html>
  <head>
  	<title>Contact V6</title>
  	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  <!--===============================================================================================-->
  	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
  <!--===============================================================================================-->
  	<link rel="stylesheet" type="text/css" href="css/util.css">
  	<link rel="stylesheet" type="text/css" href="css/main1.css">
  <!--===============================================================================================-->
  </head>
  <form class="contact100-form validate-form">
    <span class="contact100-form-title">
       Project Tracking History
    </span>

    <%
     String db = "Time";
        String user; // assumes database name is the same as username
          user = "root";
        String password = "71020900";
        try {
            java.sql.Connection con;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Time?serverTimezone=EST5EDT","root", "71020900");
            out.println(db + " Tracking App designed for you<br/><br/>");
            out.println("Project ID");
            out.println("-------");
            out.println("Team ID");
            out.println("-----------");
            out.println("Team Name");
            out.println("---------------");
            out.println("Project Name <br/><br/>");
          //  out.println("Initial entries in table SHIFT: <br/>");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT team.ProjectID, team.teamID, team.name, Project.name FROM Time.Project, Time.team WHERE team.ProjectID = Project.Id");
            while (rs.next()) {
                out.println(rs.getString(1));
                out.println("-----------------");
                out.println(rs.getString(2));
                out.println("-----------------");
                out.println(rs.getString(3));
                out.println("--------------------");
                out.println(rs.getString(4)+ "<br/>");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch(SQLException e) {
            out.println("SQLException caught: " + e.getMessage());
        }
    %><br/><br/><br/><br/>

    <div class="container-contact100-form-btn">
      <button class="contact100-form-btn">
        <span>
          <a href="http://localhost:8080/Teammember.jsp" class="txt2">
          Check the Team members
          <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i></a>
        </span>
      </button>
    </div>

<br/><br/><br/><br/>

    <div class="container-contact100-form-btn">
      <button class="contact100-form-btn">
        <span>
          <a href="http://localhost:8080/home.jsp" class="txt2">
          Back to Homepage
          <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i></a>
        </span>
      </button>
    </div>
  </body>
</html>
