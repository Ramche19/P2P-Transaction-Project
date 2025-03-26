package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
	public UserDetailsBean retrieveData(String Email_id,String password)
	{
		UserDetailsBean bean = null;
		
		try
		{
			Connection con= DBConnect.getConn();
			PreparedStatement pstm = con.prepareStatement("select * from userdetails where Email_id=? and password=?");
			pstm.setString(1,Email_id);
			pstm.setString(2, password);
			
			ResultSet rs= pstm.executeQuery();
			
			if(rs.next())
			{
				bean = new UserDetailsBean();
				bean.setEmail_id(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setMy_AccNumber(rs.getString(3));
				bean.setFname(rs.getString(4));
				bean.setBalance_amount(rs.getLong(5));
				bean.setMT_Pin(rs.getInt(6));
				bean.setPhone(rs.getLong(7));
			
			}
			
						
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return bean;
	}

}
