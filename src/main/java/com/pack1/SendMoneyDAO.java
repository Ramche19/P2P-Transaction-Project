package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Random;

public class SendMoneyDAO 
{
	long myAccountBal,ToAccountBal;
	
	String sqlQuery1 = "INSERT INTO txnhistory VALUES (?, ?, ?, ?, ?,current_timestamp)";
    String sqlQuery2 = "UPDATE userdetails SET balance_amount = balance_amount - ? WHERE My_Accountnumber = ? AND balance_amount >= ? AND mt_pin = ?";
    String sqlQuery3 = "UPDATE userdetails SET balance_amount = balance_amount + ? WHERE My_Accountnumber = ?";
    String sqlQuery4 = "UPDATE txnhistory SET status = 'Success' WHERE txnid = ?";
   
    String sqlQuery5 = "SELECT balance_amount FROM userdetails WHERE My_Accountnumber = ?";
    String sqlQuery6 = "SELECT balance_amount FROM userdetails WHERE My_Accountnumber = ?";
    String sqlQuery7 = "insert into alltransactions values(current_timestamp,?,?,?,?,?,?)";
    

    // Method to generate transaction ID
    private String generateTransactionId()
    {
        Random random = new Random();
        char letter1 = (char)('A' + random.nextInt(26));
        int number1 = 100 + random.nextInt(899);
        char letter2 = (char)('A' + random.nextInt(26)); 
        int number2 = 100 + random.nextInt(899);
        return letter1 + String.valueOf(number1)+letter2 + String.valueOf(number2);
    }
   
	//ArrayList<Object> al = new ArrayList<Object>();
	
	//ErrorBean erbean = null;
	
	
    public SendMoneyBean sendmoneyDAO(String MyAcc_number,String ReceiverAcc_number,long trans_amount,int mt_pin )
    {
    	Connection con = null;
    	SendMoneyBean smbean = null;
    	
    	
    	try {
        	con = DBConnect.getConn();
            System.out.println("Database Connected");
            con.setAutoCommit(false);
            smbean = new SendMoneyBean();
            
            // Validate sender's account number
            if (!isValidAccount(con, MyAcc_number)) {
            	smbean.setErrstatus(1);
            	smbean.setMsg("Sender's account number does not exist.");
                System.out.println("Error1: Sender's account number does not exist.");
                
                return smbean;
            }

            // Validate MT_PIN
            if (!isValidPin(con, MyAcc_number, mt_pin)) {
                System.out.println("Error2: Incorrect MT_PIN.");
                smbean.setMsg("Incorrect MT_PIN.");
                smbean.setErrstatus(1);
                
                return smbean;
            }

            // Validate sufficient balance
            if (!hasSufficientBalance(con, MyAcc_number, trans_amount)) {
                System.out.println("Error3: Insufficient balance.");
                smbean.setMsg("Insufficient balance.");
                smbean.setErrstatus(1);
                
                return smbean;
            }

            // Validate receiver's account number
            if (!isValidAccount(con, ReceiverAcc_number)) {
                System.out.println("Error4: Receiver's account number does not exist.");
                smbean.setMsg(" Receiver's account number does not exist.");
                smbean.setErrstatus(1);
                
                return smbean;
            }
            

            // Generate unique transaction ID
            String transaction_id = generateTransactionId();
            System.out.println("Transaction Initiated");
            System.out.println("Generated Transaction ID: " + transaction_id);

            // Insert transaction record
            PreparedStatement pstm1 = con.prepareStatement(sqlQuery1);
                pstm1.setString(1, transaction_id);
                pstm1.setString(2, MyAcc_number);
                pstm1.setString(3, ReceiverAcc_number);
                pstm1.setLong(4, trans_amount);
                pstm1.setString(5, "Failed");
                int rc1 = pstm1.executeUpdate();
                if(rc1==0)
                {
                	System.out.println("TxnHistory Log not Inserted");
                    smbean.setMsg("Transaction Failed");
                    smbean.setErrstatus(1);
                    return smbean;
                   
                	
                }
                
                
            

            // Create a savepoint
            Savepoint sp = con.setSavepoint();
            
            // Debit amount from sender's account
            PreparedStatement pstm2 = con.prepareStatement(sqlQuery2);
            
            pstm2.setLong(1, trans_amount);
            pstm2.setString(2, MyAcc_number);
            pstm2.setLong(3, trans_amount);
            pstm2.setInt(4, mt_pin);
            int rc2 = pstm2.executeUpdate();
            if(rc2==0)
            {
            	System.out.println("TxnHistory Log not Inserted");
                smbean.setMsg("Transaction Failed");
                smbean.setErrstatus(1);
                return smbean;
                
            	
            }

       try {
                
                
                

                // Credit amount to receiver's account
                PreparedStatement pstm3 = con.prepareStatement(sqlQuery3); 
                    pstm3.setLong(1, trans_amount);
                    pstm3.setString(2, ReceiverAcc_number);
                    int rc3 = pstm3.executeUpdate();
                    if(rc3==0)
                    {
                    	throw new SQLException("Transaction Failed");
                    }
                    
               
                

                // Update transaction status to "Success"
                PreparedStatement pstm4 = con.prepareStatement(sqlQuery4);
                    pstm4.setString(1, transaction_id);
                    int rc4 = pstm4.executeUpdate();
                    if(rc4==0)
                    {
                    	throw new SQLException("Transaction Failed");
                    	
                    }	
                
                    else 
                    {
		                System.out.println("***Transaction Successful***");
		                con.commit();
		                smbean.setAmount(trans_amount);
		                smbean.setMsg("Transaction Succesfull <br><br> Rs."+trans_amount+" is sent to Account Number:"+ReceiverAcc_number+"<br>");
		                smbean.setToAcc_Number(ReceiverAcc_number);
		                smbean.setTrans_id(transaction_id);
		                if(MyAcc_number.equals("BANK"))
		                	smbean.setErrstatus(2);
		                else
		                	smbean.setErrstatus(0);
                    }
            }
            catch (SQLException e) {
                System.out.println("***Transaction Failed*** Rolling back to savepoint...");
                con.rollback(sp);
                smbean.setAmount(trans_amount);
                smbean.setMsg("Transaction Failed\nRolled Back to Save Point.");
                smbean.setToAcc_Number(ReceiverAcc_number);
                smbean.setTrans_id(transaction_id);
                smbean.setErrstatus(1);
                e.printStackTrace();
                return smbean;
            }
       
	     try (PreparedStatement pstm5 = con.prepareStatement(sqlQuery5)) {
	     pstm5.setString(1, MyAcc_number);
	     ResultSet rs = pstm5.executeQuery();
	         if (rs.next()) {
	             System.out.println("Updated Total Balance of MyAccount: Rs." + rs.getInt(1) + "/-");
	             myAccountBal = rs.getInt(1);
	         
	     }
	 }
	 try (PreparedStatement pstm6 = con.prepareStatement(sqlQuery6)) {
	     pstm6.setString(1, ReceiverAcc_number);
	     ResultSet rs = pstm6.executeQuery();
	         if (rs.next()) {
	             System.out.println("Updated Total Balance of Receiver's Account: Rs." + rs.getInt(1) + "/-");
	             ToAccountBal = rs.getInt(1);
	     }        
	 }
       
       // Log transaction into alltransactions
       try(PreparedStatement pstm7 = con.prepareStatement(sqlQuery7)){
           pstm7.setString(1, transaction_id);
           pstm7.setString(2, MyAcc_number);
           pstm7.setString(3, ReceiverAcc_number);
           pstm7.setLong(4, trans_amount);
           pstm7.setLong(5, myAccountBal);
           pstm7.setLong(6, ToAccountBal);
           
           int rc7 = pstm7.executeUpdate();
           if(rc7>0)
           System.out.println("Transaction Logged");
           con.commit();
       }
   }
    catch (Exception e) {
            e.printStackTrace();
        }
    	
       return smbean; 
    }

    // methods for validations
    private boolean isValidAccount(Connection con, String accountNumber) throws SQLException {
        String query = "SELECT COUNT(*) FROM userdetails WHERE My_Accountnumber = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private boolean isValidPin(Connection con, String accountNumber, int pin) throws SQLException {
        String query = "SELECT COUNT(*) FROM userdetails WHERE My_Accountnumber = ? AND mt_pin = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            stmt.setInt(2, pin);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private boolean hasSufficientBalance(Connection con, String accountNumber, long amount) throws SQLException {
        String query = "SELECT balance_amount FROM userdetails WHERE My_Accountnumber = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) >= amount;
            }
        }
    }




}
