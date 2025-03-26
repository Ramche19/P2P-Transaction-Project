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

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		
		
		UserDetailsBean bean = new LoginDAO().retrieveData(req.getParameter("Email"), req.getParameter("password"));
		System.out.println("Details entered:");
		System.out.println(req.getParameter("Email"));
		System.out.println(req.getParameter("password"));
		if(bean == null)
		{
			req.setAttribute("msg", "Invalid Credentials!");
			RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("bean", bean);
			
		
			RequestDispatcher rd = req.getRequestDispatcher("accounts");
			rd.forward(req, res);
			
		}
		
		
	}

}
