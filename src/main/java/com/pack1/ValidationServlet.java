package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validation")
public class ValidationServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String data = req.getParameter("data");
		int index = data.indexOf('@');
		if(index != -1) // data is email
		{
			
			boolean isValid = new ValidationDAO().validEmail(data);
			if(isValid) {
					System.out.println("isValid Email");
					req.setAttribute("credData", data);
					req.setAttribute("credType", "Email");
					req.getRequestDispatcher("setPassword.jsp").forward(req, res);
					}
			else {
				req.setAttribute("msg", "Invalid Email Please Try again");
				req.getRequestDispatcher("ForgotPassword.jsp").forward(req, res);
				}
		}
		else //data is AccountNumber
		{
			
			boolean isValid = new ValidationDAO().validAcc(data);
			if(isValid) {
				System.out.println("isValid Account");
				req.setAttribute("credData", data);
				req.setAttribute("credType", "Account");
				req.getRequestDispatcher("setPassword.jsp").forward(req, res);
		}
			else {
				req.setAttribute("msg", "Invalid Account Number Please Try again");
				req.getRequestDispatcher("ForgotPassword.jsp").forward(req, res);
				
			}
		}
		
		
	}

}
