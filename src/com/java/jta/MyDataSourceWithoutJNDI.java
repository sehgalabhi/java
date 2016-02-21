package com.java.jta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class MyDataSourceWithoutJNDI {

	public static void main(String[] args) throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setUser("abhi");
		ods.setPassword("changeme");
		ods.setDriverType("oracle.jdbc.OracleDriver");
		ods.setNetworkProtocol("ipc");

		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		// Retrieve a connection
		Connection conn = ods.getConnection();
	
		getUserName(conn);// Close the connection
	    conn.close();
	    conn = null;

	}

	static void getUserName(Connection conn) throws SQLException {
		// Create a Statement
		Statement stmt = conn.createStatement();

		// Select the ENAME column from the EMP table
		ResultSet rset = stmt.executeQuery("select USER from dual");

		// Iterate through the result and print the employee names
		while (rset.next())
			System.out.println("User name is " + rset.getString(1));

		// Close the RseultSet
		rset.close();
		rset = null;

		// Close the Statement
		stmt.close();
		stmt = null;
	}

}
