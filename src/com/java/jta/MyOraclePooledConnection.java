package com.java.jta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class MyOraclePooledConnection {
	public static void main(String[] args) throws SQLException {
		OracleConnectionPoolDataSource ods = new OracleConnectionPoolDataSource();
		ods.setUser("hr");
		ods.setPassword("changeme");
		ods.setDriverType("oracle.jdbc.OracleDriver");
		ods.setNetworkProtocol("ipc");

		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		// Retrieve a connection
		PooledConnection pooledConnection = ods.getPooledConnection();

		Connection conn = pooledConnection.getConnection();

		getUserName(conn);// Close the connection
		conn.close();
		pooledConnection.close();
		conn = null;
		pooledConnection = null;

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
