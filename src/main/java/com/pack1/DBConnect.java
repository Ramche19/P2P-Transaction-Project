package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect implements DBInfo
{
  private static Connection con = null;
  
 
  static
  {
	 
	  try 
	  {
		  Class.forName("org.postgresql.Driver");
		  con = DriverManager.getConnection(url, user, password);
		  System.out.println("DB Connected");
		  
	  }
	  catch (Exception e) 
	  {
		e.printStackTrace();
	  }
    
  }
  
  public static Connection getConn() {
	    try {
	        if (con == null || con.isClosed()) {
	            System.out.println("Reconnecting to the database...");
	            con = DriverManager.getConnection(url, user, password);
	        } else {
	            // Keep the connection alive
	            con.createStatement().executeQuery("SELECT 1");
	        }
	    } catch (Exception e) {
	        System.err.println("Database reconnection failed!");
	        e.printStackTrace();
	    }
	    return con;
	}

}
