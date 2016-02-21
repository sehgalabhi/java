package com.java.jta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.jdbc.pool.OracleDataSource;

public class MyDataSourceWithJNDI {

	public static void main(String[] args) throws SQLException, NamingException {
		Hashtable<String, String> env = new Hashtable<>(5);

		Context ctx = null;
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL, "file:/tmp/JNDI");
		ctx = new InitialContext(env);
		do_bind(ctx, "jdbc/test");
		do_lookup(ctx, "jdbc/test");

	}

	static void do_bind(Context ctx, String ln) throws SQLException, NamingException {
		// Create a OracleDataSource instance explicitly
		OracleDataSource ods = new OracleDataSource();

		// Set the user name, password, driver type and network protocol
		ods.setUser("hr");
		ods.setPassword("changeme");
		ods.setDriverType("oracle.jdbc.OracleDriver");
		ods.setNetworkProtocol("ipc");
		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		// Bind it
		System.out.println("Doing a bind with the logical name : " + ln);
		ctx.bind(ln, ods);
	}

	static void do_lookup(Context ctx, String ln) throws NamingException, SQLException {
		System.out.println("Doing a lookup with the logical name : " + ln);
		OracleDataSource ods = (OracleDataSource) ctx.lookup(ln);
		Connection conn = ods.getConnection();

		getUserName(conn);
		// Close the connection
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
