package com.pack1;

import java.io.Serializable;

public class TransactionBean implements Serializable
{
	private String TxnId;
	private String To_AccountNumber;
	private long txnAmount;
	private String Status;
	private int rowCount;
	private String txntime;
	
	
	public String getTxntime() {
		return txntime;
	}
	public void setTxntime(String txntime) {
		this.txntime = txntime;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getTxnId() {
		return TxnId;
	}
	public void setTxnId(String txnId) {
		TxnId = txnId;
	}
	public String getTo_AccountNumber() {
		return To_AccountNumber;
	}
	public void setTo_AccountNumber(String to_AccountNumber) {
		To_AccountNumber = to_AccountNumber;
	}
	public long getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(long txnAmount) {
		this.txnAmount = txnAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
