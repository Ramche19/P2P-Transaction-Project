package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet
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
		
		else 
		{
		UserDetailsBean updatedbean = (UserDetailsBean)session.getAttribute("updatedbean");
		
		TransactionDAO tdao = new TransactionDAO();
		
		ArrayList<TransactionBean> al = tdao.retrieveData(updatedbean.getMy_AccNumber());
		req.setAttribute("data", al);
		RequestDispatcher rd = req.getRequestDispatcher("MyTransactions.jsp");
		rd.forward(req, res);
		
		}
		
		
	}
}