package com.java.jta;

import javax.transaction.xa.Xid;

public class MyXid implements Xid {

	protected byte[] bqual;
	protected byte[] gtrid;
	protected int formatId;

	public MyXid(int formatId, byte gtrid[], byte bqual[]) {
		this.formatId = formatId;
		this.gtrid = gtrid;
		this.bqual = bqual;
	}

	@Override
	public byte[] getBranchQualifier() {
		// TODO Auto-generated method stub
		return bqual;
	}

	@Override
	public int getFormatId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte[] getGlobalTransactionId() {
		// TODO Auto-generated method stub
		return gtrid;
	}

}
