package servlets;

import java.sql.*;

public class SQLExample {
   static final String DB_URL = "jdbc:mysql://localhost/bearer";
   static final String USER = "guest";
   static final String PASS = "guest";

   public static void main(String[] args) {

      String sqlQuery = "select name from users where id='"+ args[1] + "'"
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sqlQuery);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.println(", Name: " + rs.getString("name"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}