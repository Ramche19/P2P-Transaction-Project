package com.pack1;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addmoney")
public class AddMoneyServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			req.setAttribute("msg", "Session Expired!!");
			RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
			rd.forward(req, res);
		}
		else {
		Random random = new Random();
		long otp_pin = 100000+random.nextInt(899999);
		System.out.println("==>The Generated OTP is: "+otp_pin);
		int rowCount = new AddMoneyDAO().setOTP(otp_pin);
		if(rowCount>0)
		{
			System.out.println("OTP updated with db");
			session.setAttribute("otp",otp_pin);
			
			SendMoneyBean sb = new SendMoneyBean();
			sb.setToAcc_Number(req.getParameter("RAccNumber"));
			sb.setFromAcc_Number(req.getParameter("AccNumber"));
			sb.setAmount(Long.parseLong(req.getParameter("amount")));
			req.setAttribute("sb", sb);
			req.getRequestDispatcher("Validation.jsp").forward(req, res);
			
			
			
		}
		else
		{
			System.out.println("OTP not Updated");
		}
		
		}
	
		
	}


}
