package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/accounts")

public class AccountsServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
		
		HttpSession session = req.getSession(false);
		String key = (String)session.getAttribute("key");
		
		if(session == null)
		{
			req.setAttribute("msg", "Session Expired!!");
			RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
			rd.forward(req, res);
		}
		
		else 
		{
		UserDetailsBean ubean = (UserDetailsBean)session.getAttribute("bean");	
		UserDetailsBean updatedbean= new LoginDAO().retrieveData(ubean.getEmail_id(),ubean.getPassword());
		
		session.setAttribute("bean", updatedbean);
		System.out.println(updatedbean.getMy_AccNumber()+" account details fetched");
		
		if(updatedbean==null) 
		{
			System.out.println("updated bean is null");
		}
		else
		{	
		
			
			RequestDispatcher rd = req.getRequestDispatcher("accounts.jsp");
			rd.forward(req, res);
			
			
		}
	  }
		
		
		
	}
	

}
