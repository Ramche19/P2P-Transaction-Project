package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUPDAO
{
	
	public int insertData(UserDetailsBean udb)
	{
		int rowCount = 0;
		try 
		{
			Connection con = DBConnect.getConn();
			PreparedStatement pstm = con.prepareStatement("insert into userdetails values(?,?,?,?,?,?,?)");
			pstm.setString(1, udb.getEmail_id());
			pstm.setString(2, udb.getPassword());
			pstm.setString(3, udb.getMy_AccNumber());
			pstm.setLong(5, 0);
			pstm.setString(4,udb.getFname());
			pstm.setInt(6, udb.getMT_Pin());
			pstm.setLong(7, udb.getPhone());
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
