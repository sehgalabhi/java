package com.java.jta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.xa.OracleXid;
import oracle.jdbc.xa.client.OracleXADataSource;

public class XAConnectionWithSuspendOrResume {
	public static void main(String[] args) throws SQLException, XAException {
		OracleDataSource ods = new OracleDataSource();
		ods.setUser("hr");
		ods.setPassword("changeme");
		ods.setDriverType("oracle.jdbc.OracleDriver");
		ods.setNetworkProtocol("ipc");

		ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		// Retrieve a connection
		Connection conn = ods.getConnection();

		// Prepare a statement to create the table
		Statement stmt = conn.createStatement();

		try {
			// Drop the test table
			stmt.execute("drop table my_table");
		} catch (SQLException e) {
			// Ignore an error here
		}

		try {
			// Create a test table
			stmt.execute("create table my_table (col1 int)");
		} catch (SQLException e) {
			// Ignore an error here too
		}
		try {
			// Drop the test table
			stmt.execute("drop table my_tab");
		} catch (SQLException e) {
			// Ignore an error here
		}

		try {
			// Create a test table
			stmt.execute("create table my_tab (col1 int)");
		} catch (SQLException e) {
			// Ignore an error here too
		}

		OracleXADataSource odscaods = new OracleXADataSource();
		odscaods.setUser("hr");
		odscaods.setPassword("changeme");
		odscaods.setDriverType("oracle.jdbc.OracleDriver");
		odscaods.setNetworkProtocol("ipc");

		odscaods.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		XAConnection xaConnection = odscaods.getXAConnection();
		Connection conn1 = xaConnection.getConnection();
		XAResource xaResource = xaConnection.getXAResource();
		Xid xid1 = createXid(111, 111);
		// Start a transaction branch
		xaResource.start(xid1, XAResource.TMNOFLAGS);
		// Create a Statement
		Statement stmt1 = conn1.createStatement();

		// Do some DML
		stmt1.executeUpdate("insert into my_table values (2727)");
		// Suspend the first global transaction
		xaResource.end(xid1, XAResource.TMSUSPEND);

		Xid xid2 = createXid(222, 222);
		xaResource.start(xid2, XAResource.TMNOFLAGS);
		Statement stmt2 = conn1.createStatement();
		stmt2.executeUpdate("insert into my_tab values (7272)");
		xaResource.commit(xid2, true);
		stmt2.close();
		stmt2 = null;

		// Close the Statement
		stmt1.close();
		stmt1 = null;

		// Resume the first global transaction
		// ((OracleXAResource)oxar).resume (xid1); or
		xaResource.start(xid1, XAResource.TMRESUME);

		// End the branch
		xaResource.end(xid1, XAResource.TMSUCCESS);

		// Do a 1 phase commit
		xaResource.commit(xid1, true);

		// Close the connection
		conn1.close();
		conn1 = null;

		// close the XA connection
		xaConnection.close();
		xaConnection = null;

		ResultSet rset = stmt.executeQuery("select col1 from my_table");
		while (rset.next())
			System.out.println("Col1 is " + rset.getInt(1));

		rset.close();
		rset = null;

		rset = stmt.executeQuery("select col1 from my_tab");
		while (rset.next())
			System.out.println("Col1 is " + rset.getString(1));

		rset.close();
		rset = null;

		stmt.close();
		stmt = null;

		conn.close();
		conn = null;

	}

	static Xid createXid(int gd, int bd) throws XAException {
		byte[] gid = new byte[1];
		gid[0] = (byte) gd;
		byte[] bid = new byte[1];
		bid[0] = (byte) bd;
		byte[] gtrid = new byte[64];
		byte[] bqual = new byte[64];
		System.arraycopy(gid, 0, gtrid, 0, 1);
		System.arraycopy(bid, 0, bqual, 0, 1);

		Xid xid = new OracleXid(0x1234, gtrid, bqual);
		return xid;
	}
}
