package com.java.jta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.OracleDriver;
import oracle.jdbc.xa.OracleXid;
import oracle.jdbc.xa.client.OracleXADataSource;

public class XAWithTwoPhaseCommit {
	public static void main(String[] args) throws SQLException, XAException {
		String URL1 = "jdbc:oracle:thin:@(description=" + "(address=(host=localhost)(protocol=tcp) "
				+ "(port=1521))(connect_data=(sid=xe)))";
		String URL2 = "jdbc:oracle:thin:@(description=" + "(address=(host=localhost)(protocol=tcp) "
				+ "(port=1521))(connect_data=(sid=xe)))";

		DriverManager.registerDriver(new OracleDriver());

		// You can put a database name after the @ sign in the connection URL.
		Connection conna = DriverManager.getConnection(URL1, "hr", "changeme");

		// Prepare a statement to create the table
		Statement stmta = conna.createStatement();

		Connection connb = DriverManager.getConnection(URL2, "hr", "changeme");

		// Prepare a statement to create the table
		Statement stmtb = connb.createStatement();

		try {
			// Drop the test table
			stmta.execute("drop table my_table");
		} catch (SQLException e) {
			// Ignore an error here
		}

		try {
			// Create a test table
			stmta.execute("create table my_table (col1 int)");
		} catch (SQLException e) {
			// Ignore an error here too
		}

		try {
			// Drop the test table
			stmtb.execute("drop table my_tab");
		} catch (SQLException e) {
			// Ignore an error here
		}

		try {
			// Create a test table
			stmtb.execute("create table my_tab (col1 char(30))");
		} catch (SQLException e) {
			// Ignore an error here too
		}

		OracleXADataSource odscaods1 = new OracleXADataSource();
		odscaods1.setUser("hr");
		odscaods1.setPassword("changeme");
		odscaods1.setDriverType("oracle.jdbc.OracleDriver");
		odscaods1.setNetworkProtocol("tcp");

		odscaods1.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		OracleXADataSource odscaods2 = new OracleXADataSource();
		odscaods2.setUser("hr");
		odscaods2.setPassword("changeme");
		odscaods2.setDriverType("oracle.jdbc.OracleDriver");
		odscaods2.setNetworkProtocol("tcp");

		odscaods2.setURL("jdbc:oracle:thin:@localhost:1521:xe");

		XAConnection xaConn1 = odscaods1.getXAConnection();

		Connection conn1 = xaConn1.getConnection();

		XAConnection xaConn2 = odscaods2.getXAConnection();

		Connection conn2 = xaConn2.getConnection();
		// Get the XA Resources
		XAResource oxar1 = xaConn1.getXAResource();
		XAResource oxar2 = xaConn2.getXAResource();

		// Create the Xids With the Same Global Ids
		Xid xid1 = createXid(1);
		Xid xid2 = createXid(2);

		// Start the Resources
		oxar1.start(xid1, XAResource.TMNOFLAGS);
		oxar2.start(xid2, XAResource.TMNOFLAGS);

		// Do something with conn1 and conn2
		doSomeWork1(conn1);
		doSomeWork2(conn2);

		// END both the branches -- THIS IS MUST
		oxar1.end(xid1, XAResource.TMSUCCESS);
		oxar2.end(xid2, XAResource.TMSUCCESS);

		// Prepare the RMs
		int prp1 = oxar1.prepare(xid1);
		int prp2 = oxar2.prepare(xid2);

		System.out.println("Return value of prepare 1 is " + prp1);
		System.out.println("Return value of prepare 2 is " + prp2);

		boolean do_commit = true;

		if (!((prp1 == XAResource.XA_OK) || (prp1 == XAResource.XA_RDONLY)))
			do_commit = false;

		if (!((prp2 == XAResource.XA_OK) || (prp2 == XAResource.XA_RDONLY)))
			do_commit = false;

		System.out.println("do_commit is " + do_commit);
		System.out.println("Is oxar1 same as oxar2 ? " + oxar1.isSameRM(oxar2));

		if (prp1 == XAResource.XA_OK)
			if (do_commit)
				oxar1.commit(xid1, false);
			else
				oxar1.rollback(xid1);
		if (prp2 == XAResource.XA_OK)
			if (do_commit)
				oxar2.commit(xid2, false);
			else
				oxar2.rollback(xid2);

		// Close connections
		conn1.close();
		conn1 = null;
		conn2.close();
		conn2 = null;

		xaConn1.close();
		xaConn1 = null;
		xaConn2.close();
		xaConn2 = null;

		ResultSet rset = stmta.executeQuery("select col1 from my_table");
		while (rset.next())
			System.out.println("Col1 is " + rset.getInt(1));

		rset.close();
		rset = null;

		rset = stmtb.executeQuery("select col1 from my_tab");
		while (rset.next())
			System.out.println("Col1 is " + rset.getString(1));

		rset.close();
		rset = null;

		stmta.close();
		stmta = null;
		stmtb.close();
		stmtb = null;

		conna.close();
		conna = null;
		connb.close();
		connb = null;
	}

	static Xid createXid(int bids) throws XAException {
		byte[] gid = new byte[1];
		gid[0] = (byte) 9;
		byte[] bid = new byte[1];
		bid[0] = (byte) bids;
		byte[] gtrid = new byte[64];
		byte[] bqual = new byte[64];
		System.arraycopy(gid, 0, gtrid, 0, 1);
		System.arraycopy(bid, 0, bqual, 0, 1);
		Xid xid = new OracleXid(0x1234, gtrid, bqual);
		return xid;
	}

	private static void doSomeWork1(Connection conn) throws SQLException {
		// Create a Statement
		Statement stmt = conn.createStatement();

		int cnt = stmt.executeUpdate("insert into my_table values (4321)");

		System.out.println("No of rows Affected " + cnt);

		stmt.close();
		stmt = null;
	}

	private static void doSomeWork2(Connection conn) throws SQLException {
		// Create a Statement
		Statement stmt = conn.createStatement();

		int cnt = stmt.executeUpdate("insert into my_tab values ('test')");

		System.out.println("No of rows Affected " + cnt);

		stmt.close();
		stmt = null;
	}
}
