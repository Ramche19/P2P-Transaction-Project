package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sendmoney")
public class SendMoneyServlet extends HttpServlet
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
		SendMoneyDAO smDAO = new SendMoneyDAO();
		SendMoneyBean smb = smDAO.sendmoneyDAO(req.getParameter("AccNumber"),req.getParameter("RAccNumber"),Long.parseLong(req.getParameter("amount")),Integer.parseInt(req.getParameter("mtpin")));
		
		if(smb == null) {
			System.out.println("bean is null");
		}
		int errstatus = smb.getErrstatus();
		ServletContext context = req.getServletContext();
		if(errstatus == 1)
		{
			
			context.setAttribute("eb", smb);
			RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, res);
			
		}
		else if(errstatus == 0)
		{
			
			context.setAttribute("smb", smb);
			RequestDispatcher rd = req.getRequestDispatcher("receipt.jsp");
			rd.forward(req, res);
			
		}
		else
		{
		
			context.setAttribute("smb", smb);
			RequestDispatcher rd = req.getRequestDispatcher("receipt2.jsp");
			rd.forward(req, res);
			
		}
		
	}
	}

}
