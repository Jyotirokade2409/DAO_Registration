package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.registration;
import com.dao.registerDAO;

/**
 * Servlet implementation class allusers
 */
@WebServlet("/allusers")
public class allusers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		registerDAO d=new registerDAO();
		PrintWriter p=response.getWriter();
		List<registration> users=new ArrayList<>();
		users.addAll(d.getUser());
		//p.println(d.getUser());
		p.println("<table cellspacing='0' width='35px' border='1px'");
		p.println("<tr>");
		p.println("<th>Username</th>");
		p.println("<th>Password</th>");
		p.println("<th>Confirm_Password</th>");
		p.println("<th>Email</th>");
		
		for(registration u:users)
		{
			p.println("<tr>");
			p.println("<td>"+u.getUname()+"</td>");
			p.println("<td>"+u.getPass()+"</td>");
			p.println("<td>"+u.getCpass()+"</td>");
			p.println("<td>"+u.getEmail()+"</td>");
			p.println("<td>"+"<a href='Delete?username'>Delete</a></td>");
			p.println("<td>"+"<a href=''>Update</a></td>");
			p.println("</tr>");
			//p.println(u);
		}
		p.println("</table>");
	}
	//registerDAO d1=new registerDAO();
    

}
