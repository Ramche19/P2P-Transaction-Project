package com.pack1;

import java.io.Serializable;

public class SendMoneyBean implements Serializable
{
	private String FromAcc_Number;
	
	private int errstatus;
	private String msg;
	private String ToAcc_Number;
	private String trans_id;
	private long amount;
	
	public String getFromAcc_Number() {
		return FromAcc_Number;
	}
	public void setFromAcc_Number(String fromAcc_Number) {
		FromAcc_Number = fromAcc_Number;
	}
	public int getErrstatus() {
		return errstatus;
	}
	public void setErrstatus(int errstatus) {
		this.errstatus = errstatus;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getToAcc_Number() {
		return ToAcc_Number;
	}
	public void setToAcc_Number(String toAcc_Number) {
		ToAcc_Number = toAcc_Number;
	}
	public String getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	
	

}
