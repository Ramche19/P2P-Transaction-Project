package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setpwd")
public class setPasswordServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String data = req.getParameter("credData");
		String credType = req.getParameter("credType");
		String password = req.getParameter("password");
		int mtpin = Integer.parseInt(req.getParameter("mtpin"));
		System.out.println(data + " "+credType+ " "+password+" "+mtpin);
		
		
		if (credType.equals("Account"))
		{
		
			int rowCount = new setPasswordDAO().updateUsingAccNum(password,mtpin,data);
			if(rowCount>0)
			{
				System.out.println("The Account Password and Pin Updated");
				req.setAttribute("msg", "Password and Pin Updated Please Login");
				req.getRequestDispatcher("info.jsp").forward(req, res);
			}
			else
			{
				System.out.println("The Account Password and Pin NOT Updated");				
				req.setAttribute("msg", "Password and Pin Not Updated<br><br> Please Try Again");
				req.getRequestDispatcher("ForgotPassword.jsp").forward(req, res);
				
			}
		}
		else if (credType.equals("Email"))
		{


			int rowCount = new setPasswordDAO().updateUsingEmail(password,mtpin,data);
			if(rowCount>0)
			{
				System.out.println("The Account Password and Pin Updated");

				req.setAttribute("msg", "Password and Pin Updated Please Login");
				req.getRequestDispatcher("info.jsp").forward(req, res);
			}
			else
			{
				System.out.println("The Account Password and Pin NOT Updated");

				req.setAttribute("msg", "Password and Pin Not Updated<br><br> Please Try Again");
				req.getRequestDispatcher("ForgotPassword.jsp").forward(req, res);
				
			}
		}

		
		
		
	}

}
