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

@WebServlet("/statement")
public class StatementServlet extends HttpServlet
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
		
		StatementDAO sdao = new StatementDAO();
		
		ArrayList<StatementBean> al = sdao.retrieveData(updatedbean.getMy_AccNumber());
		req.setAttribute("data", al);
		RequestDispatcher rd = req.getRequestDispatcher("Statement.jsp");
		rd.forward(req, res);
		
		}
		
		
	}
}