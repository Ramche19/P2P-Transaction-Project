package com.pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession session = req.getSession(false);
		
		if(session==null)
		{
			  req.setAttribute("msg","Session Expired!!!");
			   RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
			   rd.forward(req, res);
		}
		
		else {
			UserDetailsBean udb = (UserDetailsBean) session.getAttribute("updatedbean");
			
			UpdateProfileDAO upDAO = new UpdateProfileDAO();
			
			udb.setFname(req.getParameter("fname"));
			udb.setEmail_id(req.getParameter("emailid"));
			udb.setMy_AccNumber(req.getParameter("AccNumber"));
			udb.setPhone(Long.parseLong(req.getParameter("phone")));
			
			int rowCount = upDAO.updateData(udb);
			
			if(rowCount>0)
			{
				req.setAttribute("msg","Data Updated Please Log In");
				session.invalidate();
				RequestDispatcher rd = req.getRequestDispatcher("info.jsp");
				rd.forward(req, res);
			}
		
		
		}
	}

}
