package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddMoneyDAO 
{
	public int setOTP(long mt_pin)
	{
		int rowCount=0;
		
		try
		{
			Connection con = DBConnect.getConn();
			PreparedStatement pstm = con.prepareStatement("update userdetails set mt_pin=? where my_accountnumber='BANK'");
			
			pstm.setLong(1, mt_pin);
			rowCount = pstm.executeUpdate();
			con.commit();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}

}
