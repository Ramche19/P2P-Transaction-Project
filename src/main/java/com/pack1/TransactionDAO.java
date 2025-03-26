package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionDAO 
{
	
	public ArrayList<TransactionBean> retrieveData(String My_accountNumber)
	{
		ArrayList<TransactionBean> al = new ArrayList<TransactionBean>();
		Connection con = null;
		TransactionBean tbean = null;
		try
		{
			con = DBConnect.getConn();
			PreparedStatement pstm = con.prepareStatement("SELECT TO_CHAR(txntime, 'DD-MM-YYYY HH24:MI:SS'), txnid, to_accountnumber, txnamount, status FROM txnhistory WHERE my_accountnumber = ? ORDER BY txntime DESC");
			
			pstm.setString(1,My_accountNumber);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				tbean = new TransactionBean();
				tbean.setTxnId(rs.getString(2));
				tbean.setTo_AccountNumber(rs.getString(3));
				tbean.setTxnAmount(rs.getLong(4));
				tbean.setStatus(rs.getString(5));
				tbean.setTxntime(rs.getString(1));
				al.add(tbean);
				
			}
			
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

}
