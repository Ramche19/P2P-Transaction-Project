package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO
{
	public int updateData(UserDetailsBean udb)
	{
		int rowCount=0;
		try
		{
			Connection con = DBConnect.getConn();
			PreparedStatement pstm = con.prepareStatement("update userdetails set fullname=?,email_id=?,phone_no=? where my_accountnumber=?");
			pstm.setString(1,udb.getFname());
			pstm.setString(2,udb.getEmail_id());
			pstm.setString(4,udb.getMy_AccNumber());
			pstm.setLong(3, udb.getPhone());
			System.out.println(udb.getPhone());
			
			
			rowCount = pstm.executeUpdate();
			
			
		} 
		catch (Exception e)
		{

			e.printStackTrace();
		}
		
		
		return rowCount;
	}

}
