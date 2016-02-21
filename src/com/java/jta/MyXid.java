package com.java.jta;

import javax.transaction.xa.Xid;

public class MyXid implements Xid {
	protected int formatId;
	protected byte gtrid[];
	protected byte bqual[];

	public MyXid() {
	}

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
		return formatId;
	}

	@Override
	public byte[] getGlobalTransactionId() {
		// TODO Auto-generated method stub
		return gtrid;
	}

}
