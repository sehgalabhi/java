package com.java.jta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.xa.client.OracleXADataSource;

//two different transactions on the same resource
//https://www.progress.com/jdbc/resources/tutorials/understanding-jta/distributed-transactions-and-the-transaction-manager
public class JTAEx4 {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		XAConnection xaConnection = null;
		try {
			OracleXADataSource dataSource = getXADataSource();

			xaConnection = dataSource.getXAConnection();
			XAResource xaResource = xaConnection.getXAResource();

			connection = xaConnection.getConnection();
			statement = connection.createStatement();
			int b = 0xff;
			System.out.println(b);

			Xid xid1 = new MyXid(100, new byte[] { 0x01 }, new byte[] { 0x02 });
			Xid xid2 = new MyXid(100, new byte[] { 0x11 }, new byte[] { 0x12 });

			xaResource.start(xid1, XAResource.TMNOFLAGS);

			statement.executeUpdate("insert into DEPARTMENTS values (274, 'Test TPC 274 RM', '',1700)");
			xaResource.end(xid1, XAResource.TMSUCCESS);

			xaResource.start(xid2, XAResource.TMNOFLAGS);

			int ret = xaResource.prepare(xid1);
			if (ret == XAResource.XA_OK) {
				xaResource.commit(xid1, false);
			}

			statement.executeUpdate("insert into DEPARTMENTS values (276, 'Test TPC 276 RM', '',1700)");
			xaResource.end(xid2, XAResource.TMSUCCESS);

			ret = xaResource.prepare(xid2);
			if (ret == XAResource.XA_OK) {
				xaResource.commit(xid2, false);
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
