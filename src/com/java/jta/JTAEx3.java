package com.java.jta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.xa.client.OracleXADataSource;

//a transaction outside the xa scope
//https://www.progress.com/jdbc/resources/tutorials/understanding-jta/distributed-transactions-and-the-transaction-manager
public class JTAEx3 {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		XAConnection xaConnection  = null;
		try {
			OracleXADataSource dataSource = getXADataSource();

			xaConnection = dataSource.getXAConnection();
			XAResource xaResource = xaConnection.getXAResource();

			connection = xaConnection.getConnection();
			 statement = connection.createStatement();
			int b = 0xff;
			System.out.println(b);

			Xid xid = new MyXid(100, new byte[] { 0x03 }, new byte[] { 0x04 });

			xaResource.start(xid, XAResource.TMNOFLAGS);
			statement.executeUpdate("insert into DEPARTMENTS values (274, 'Test TPC 274 RM', '',1700)");
			xaResource.end(xid, XAResource.TMSUSPEND);

		statement.executeUpdate("insert into my_tab values ('Test TPC 280 RM')");
 
			xaResource.start(xid, XAResource.TMRESUME);
			statement.executeUpdate("insert into DEPARTMENTS values (276, 'Test TPC 276 RM', '',1700)");
			xaResource.end(xid, XAResource.TMSUCCESS);

			int ret = xaResource.prepare(xid);
			if (ret == XAResource.XA_OK) {
				xaResource.rollback(xid);
			}
		} catch (XAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			statement.close();
			connection.close();
			xaConnection.close();
		}

	}

	private static OracleXADataSource getXADataSource() throws SQLException {
		OracleXADataSource dataSource = new OracleXADataSource();
		dataSource.setPortNumber(1521);
		dataSource.setURL("jdbc:oracle:thin:@localhost:1521/XE");
		// dataSource.setServerName("XE");
		dataSource.setUser("HR");
		dataSource.setPassword("HR");
		return dataSource;
	}
}
