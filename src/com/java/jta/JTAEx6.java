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
public class JTAEx6 {
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

			Xid xids[];
			xids = xaResource1.recover(XAResource.TMENDRSCAN | XAResource.TMSTARTRSCAN);

			for (int i = 0; i < xids.length; i++) {
				try {
					xaResource1.rollback(xids[i]);
				} catch (XAException z) {
					try {
						xaResource1.forget(xids[i]);
					} catch (XAException sd) {
						System.out.println("rollback/forget failed: " + sd.errorCode);
					}
				}
			}

		} catch (XAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

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
