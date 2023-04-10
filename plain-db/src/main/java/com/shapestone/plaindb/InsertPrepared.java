package com.shapestone.plaindb;

import java.sql.*;

import com.shapestone.plaindb.constants.JDBCConstants;

public class InsertPrepared {
	public void insertRecord() {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(JDBCConstants.DB_URL, JDBCConstants.USER, JDBCConstants.PASS);

			PreparedStatement stmt = con.prepareStatement("insert into Employees values(?,?,?, ?)");
			stmt.setInt(1, 402);// 1 specifies the first parameter in the query
			stmt.setInt(2, 29);
			stmt.setString(3, "Karthik");
			stmt.setString(4, "D");
			
			stmt.addBatch();
			
			stmt.setInt(1, 403);// 1 specifies the first parameter in the query
			stmt.setInt(2, 29);
			stmt.setString(3, "Naveen");
			stmt.setString(4, "G");
			stmt.addBatch();
			
			int[] i = stmt.executeBatch();
			System.out.println(i.length + " records inserted");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}