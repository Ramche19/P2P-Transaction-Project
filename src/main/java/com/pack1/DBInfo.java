package com.pack1;

public interface DBInfo 
{
    String url = "jdbc:postgresql://ep-sparkling-frog-a5lhh06q.us-east-2.aws.neon.tech:5432/neondb?sslmode=require"+ "&autoReconnect=true"
            + "&reconnectAttempts=5"
            + "&reconnectDelay=3000";
    String user = "neondb_owner";
    String password = "";

}
