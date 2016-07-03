package com.java.jta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.xa.client.OracleXADataSource;

//https://www.progress.com/jdbc/resources/tutorials/understanding-jta/distributed-transactions-and-the-transaction-manager

/**
 * Class showing two phase commit with one transaction branch;
 * @author abhi
 *
 */
public class JTAEx1 {
	public static void main(String[] args) throws SQLException {
		OracleXADataSource dataSource = getXADataSource();

		XAConnection xaConnection = dataSource.getXAConnection();
		XAResource xaResource = xaConnection.getXAResource();

		Connection connection = xaConnection.getConnection();
		Statement statement = connection.createStatement();
		int b = 0xff;
		System.out.println(b);

		Xid xid = new MyXid(100, new byte[] { 0x01 }, new byte[] { 0x02 });

		try {
			xaResource.start(xid, XAResource.TMNOFLAGS);
			statement.executeUpdate("insert into DEPARTMENTS values (271, 'Test TPC 1 RM', '',1700)");
			xaResource.end(xid, XAResource.TMSUCCESS);

			int ret = xaResource.prepare(xid);
			if (ret == XAResource.XA_OK) {
				xaResource.commit(xid, false);
			}
		} catch (XAException e) {
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
