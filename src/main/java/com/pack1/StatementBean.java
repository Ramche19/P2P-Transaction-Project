package com.pack1;

import java.io.Serializable;

public class StatementBean implements Serializable
{
	private String Date;
	private String Txn_id;
	private String Txn_type;
	private String My_accNumber;
	private String To_accNumber;
	private long Amount;
	private long ubal;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTxn_id() {
		return Txn_id;
	}
	public void setTxn_id(String txn_id) {
		Txn_id = txn_id;
	}
	public String getTxn_type() {
		return Txn_type;
	}
	public void setTxn_type(String txn_type) {
		Txn_type = txn_type;
	}
	public String getMy_accNumber() {
		return My_accNumber;
	}
	public void setMy_accNumber(String my_accNumber) {
		My_accNumber = my_accNumber;
	}
	public String getTo_accNumber() {
		return To_accNumber;
	}
	public void setTo_accNumber(String to_accNumber) {
		To_accNumber = to_accNumber;
	}
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	public long getUbal() {
		return ubal;
	}
	public void setUbal(long ubal) {
		this.ubal = ubal;
	}

}
