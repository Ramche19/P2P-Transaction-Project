package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidationDAO 
{
	public boolean validAcc(String MyAcc_number)
	{
		try 
		{
			Connection con = DBConnect.getConn();
			
			 if (isValidAccount(con, MyAcc_number))
				 return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean validEmail(String email_id)
	{
		try 
		{
			Connection con = DBConnect.getConn();
			
			 if (isValidEmail(con, email_id))
				 return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	//validation methods from SendMoneyDAO
	   private boolean isValidAccount(Connection con, String accountNumber) throws SQLException
	   {
	        String query = "SELECT COUNT(*) FROM userdetails WHERE My_Accountnumber = ?";
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	            stmt.setString(1, accountNumber);
	            try (ResultSet rs = stmt.executeQuery()) {
	                return rs.next() && rs.getInt(1) > 0;
	            }
	        }
	    }
	   
	   private boolean isValidEmail(Connection con, String email_id) throws SQLException
	   {
	        String query = "SELECT COUNT(*) FROM userdetails WHERE Email_id = ?";
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	            stmt.setString(1, email_id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                return rs.next() && rs.getInt(1) > 0;
	            }
	        }
	    }
}
