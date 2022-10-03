package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.beans.registration;
import com.databaseconn.JDBCconnection;
import com.mysql.cj.xdevapi.Result;



public class registerDAO 
{
   
    public boolean deletedata(registration reg)
    {
        String sql="delete from employee3 where uname=?";
        try {
            PreparedStatement st=JDBCconnection.getconnect().prepareStatement(sql);
            st.setString(1, reg.getUname());
            
            return st.executeUpdate()>0;
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
   
  

	public boolean insertdata(registration r) {
		// TODO Auto-generated method stub
		
		String sql="insert into employee3 values(?,?,?,?)";
        try {
            PreparedStatement st=JDBCconnection.getconnect().prepareStatement(sql);
            st.setString(1, r.getUname());
            st.setString(2, r.getPass());
            st.setString(3, r.getCpass());
            st.setString(4, r.getEmail());
            return st.executeUpdate()>0;
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
		return false;
	}
	
	public boolean updaterecord(String user,String passw,String cpassw,String emailid)
    {
        String sql="update employee3 set pass=?,cpass=?,email=? where uname=? ";
        
        PreparedStatement st;
        try
        {
            st = JDBCconnection.getconnect().prepareStatement(sql);
            st.setString(1, user);
           
            
            return st.executeUpdate()>0;
            
            
            
        }
        
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        
        return false;
    }
	
	public registration getUser(String user)
    {



       String sql="select * from  employee3 where uname=?";
    registration reg=null;
        try {
            PreparedStatement st=JDBCconnection.getconnect().prepareStatement(sql);
            st.setString(1, user);
            ResultSet res=st.executeQuery();
            while(res.next())
            {
                String username=res.getString("uname");
                String pass=res.getString("pass");
                String cpass=res.getString("cpass");
                String email=res.getString("email");
                reg=new registration(username,pass,cpass,email);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    return reg;
    }
	
public List<registration>  getUser()
    
    {
        List<registration> list=new ArrayList<>();
        String sql="select * from employee3";
        
        try {
            PreparedStatement st=JDBCconnection.getconnect().prepareStatement(sql);
            ResultSet res=st.executeQuery();
            registration users=null;
            
            while(res.next())
            {
                String username=res.getString("uname");
                String password=res.getString("pass");
                String cpassword=res.getString("cpass");
                String email=res.getString("email");
                users=new registration(username, password, cpassword, email);
                list.add(users);
                
            }
            
        }
        
        
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return list;
        
    }
	
	
}





