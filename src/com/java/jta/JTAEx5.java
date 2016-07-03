package com.java.jta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import oracle.jdbc.xa.client.OracleXADataSource;

//transaction management for two diferent xa resources usin same resource
//https://www.progress.com/jdbc/resources/tutorials/understanding-jta/distributed-transactions-and-the-transaction-manager
public class JTAEx5 {
	public static void main(String[] args) throws SQLException {
		Connection connection1 = null;
		Connection connection2 = null;
		Statement statement1 = null;
		Statement statement2 = null;
		XAConnection xaConnection1 = null;
		XAConnection xaConnection2 = null;
		try {
			OracleXADataSource dataSource = getXADataSource();

			xaConnection1 = dataSource.getXAConnection();
			xaConnection2 = dataSource.getXAConnection();
			XAResource xaResource1 = xaConnection1.getXAResource();
			XAResource xaResource2 = xaConnection2.getXAResource();

			connection1 = xaConnection1.getConnection();
			statement1 = connection1.createStatement();

			connection2 = xaConnection2.getConnection();
			statement2 = connection2.createStatement();

			Xid xid1 = new MyXid(100, new byte[] { 0x03 }, new byte[] { 0x02 });
			Xid xid2 = new MyXid(100, new byte[] { 0x02 }, new byte[] { 0x12 });

			xaResource1.start(xid1, XAResource.TMNOFLAGS);

			statement1.executeUpdate("insert into DEPARTMENTS values (274, 'Test TPC 274 RM', '',1700)");
			xaResource1.end(xid1, XAResource.TMSUCCESS);

			if (xaResource2.isSameRM(xaResource1)) {
				xaResource2.start(xid1, XAResource.TMJOIN);
				statement2.executeUpdate("insert into DEPARTMENTS values (276, 'Test TPC 276 RM', '',1700)");
				xaResource2.end(xid1, XAResource.TMSUCCESS);
			} else {
				xaResource2.start(xid2, XAResource.TMNOFLAGS);
				statement2.executeUpdate("insert into DEPARTMENTS values (276, 'Test TPC 276 RM', '',1700)");
				xaResource2.end(xid2, XAResource.TMSUCCESS);
				int ret = xaResource2.prepare(xid2);
				if (ret == XAResource.XA_OK) {
					xaResource1.commit(xid2, false);
				}
			}
			int ret = xaResource1.prepare(xid1);
			if (ret == XAResource.XA_OK) {
				xaResource1.commit(xid1, false);
			}
		} catch (XAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			statement1.close();
			connection1.close();
			xaConnection1.close();
			statement2.close();
			connection2.close();
			xaConnection2.close();
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
