package com.shapestone.plaindb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shapestone.plaindb.constants.JDBCConstants;

/**
 * RetreiveExample this class is used to contains the data fetching related operations 
 * @author surya
 *
 */
public class RetreiveExample {
  
   static final String QUERY = "SELECT id, first, last, age FROM Employees";

   /**
    * Displaying data.
    */
   public void displayData() {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(JDBCConstants.DB_URL, JDBCConstants.USER, JDBCConstants.PASS);
         Statement stmt = conn.createStatement();
//    		  stmt.execute(QUERY);
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}