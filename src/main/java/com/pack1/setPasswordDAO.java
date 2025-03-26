package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class setPasswordDAO 
{
	public int updateUsingAccNum(String password,int mtpin,String Accnum)
	{
		int rowCount=0;
		try
		{
			Connection con = DBConnect.getConn();
			System.out.println("DbConnected");			
			PreparedStatement pstm = con.prepareStatement("update userdetails set password=?,mt_pin=? where my_accountnumber=?");
			pstm.setString(1,password);
			pstm.setInt(2,mtpin);
			pstm.setString(3,Accnum);
			
			rowCount = pstm.executeUpdate();
			System.out.println("query executed");
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rowCount;
	}
	
	public int updateUsingEmail(String password,int mtpin,String Email)
	{
		int rowCount=0;
		try
		{
			Connection con = DBConnect.getConn();
			System.out.println("DbConnected");
			PreparedStatement pstm = con.prepareStatement("update userdetails set password=?,mt_pin=? where email_id=?");
			pstm.setString(1,password);
			pstm.setInt(2,mtpin);
			pstm.setString(3,Email);
			
			rowCount = pstm.executeUpdate();
			System.out.println("query executed");
			
		} 
		catch (Exception e)
		{

			e.printStackTrace();
		}
		
		
		return rowCount;
	}
	
	

}

