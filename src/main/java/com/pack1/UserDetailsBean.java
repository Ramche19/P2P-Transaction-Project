package com.pack1;

import java.io.Serializable;

public class UserDetailsBean implements Serializable 
{
	private String My_AccNumber;
	private long Balance_amount;
	private String Email_id;
	private String Password;
	private int MT_Pin;
	private String Fname;
	private long phone;
	private boolean errStatus;
	
	public boolean isErrStatus() {
		return errStatus;
	}
	public void setErrStatus(boolean errStatus) {
		this.errStatus = errStatus;
	}
	public long getPhone(){
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMy_AccNumber() {
		return My_AccNumber;
	}
	public void setMy_AccNumber(String my_AccNumber) {
		My_AccNumber = my_AccNumber;
	}
	public long getBalance_amount() {
		return Balance_amount;
	}
	public void setBalance_amount(long balance_amount) {
		Balance_amount = balance_amount;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getMT_Pin() {
		return MT_Pin;
	}
	public void setMT_Pin(int mT_Pin) {
		MT_Pin = mT_Pin;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	
	
	
	

}
