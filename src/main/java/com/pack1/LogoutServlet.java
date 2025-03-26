package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		
	   HttpSession session = req.getSession(false);
	   if(session == null)
	   {
		   req.setAttribute("msg","Session Expired!!!");
		   RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
		   rd.forward(req, res);
	   }
	   else
	   {
		   session.invalidate();
		   
		   
		   req.setAttribute("msg", "User logged out Succesfully!!");
		   RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
		   rd.forward(req, res);
		   
		   
				   
		}
		
	}

}
