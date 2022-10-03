package com.databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection
{
    public static Connection connect;
    public static Connection getconnect() throws SQLException
    {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/soprastearia", "root", "Kolhapur@416503");
            return connect;
            
        } catch (ClassNotFoundException e)
        {
            
            e.printStackTrace();
        }
        
        return null;
    }









}
