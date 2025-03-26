package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StatementDAO 
{
	
	public ArrayList<StatementBean> retrieveData(String My_accountNumber)
	{
		ArrayList<StatementBean> al = new ArrayList<StatementBean>();
		Connection con = null;
		StatementBean sbean = null;
		try
		{
			con = DBConnect.getConn();
			PreparedStatement pstm = con.prepareStatement("SELECT TO_CHAR(txntime, 'DD-MM-YYYY HH24:MI:SS'), txnid, my_accountnumber, to_accountnumber, CASE WHEN my_accountnumber = ? THEN 'DEBIT' WHEN to_accountnumber = ? THEN 'CREDIT' END, amount, COALESCE(CASE WHEN my_accountnumber = ? THEN from_ubal WHEN to_accountnumber = ? THEN to_ubal END, 0) FROM alltransactions WHERE my_accountnumber = ? OR to_accountnumber = ? ORDER BY txntime DESC");
			
			pstm.setString(1,My_accountNumber);
			pstm.setString(2,My_accountNumber);
			pstm.setString(3,My_accountNumber);
			pstm.setString(4,My_accountNumber);
			pstm.setString(5,My_accountNumber);
			pstm.setString(6,My_accountNumber);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next())
			{
				sbean = new StatementBean();
				sbean.setDate(rs.getString(1));
				sbean.setTxn_id(rs.getString(2));
				sbean.setMy_accNumber(rs.getString(3));
				sbean.setTo_accNumber(rs.getString(4));
				sbean.setTxn_type(rs.getString(5));
				sbean.setAmount(rs.getLong(6));
				sbean.setUbal(rs.getLong(7));
				al.add(sbean);
				
			}
			
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

}
