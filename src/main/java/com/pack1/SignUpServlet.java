package com.pack1;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		String accno = generateAccountNumber();
		
		UserDetailsBean udb = new UserDetailsBean();
		udb.setEmail_id(req.getParameter("Email"));
		udb.setPassword(req.getParameter("pwd"));
		udb.setBalance_amount(0);
		udb.setFname(req.getParameter("fname"));
		udb.setMT_Pin(Integer.parseInt(req.getParameter("mtpin")));
		udb.setMy_AccNumber(accno);
		udb.setPhone(Long.parseLong(req.getParameter("phone")));
		
		int rowCount = new SignUPDAO().insertData(udb);
		if(rowCount>0)
		{
			req.setAttribute("msg", "Account Created with Account Number: "+accno+"<br><center>Please Login</center>");
			req.getRequestDispatcher("info.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Account NOT Created Please Try Again");
			req.getRequestDispatcher("info.jsp").forward(req, res);
						
		}
		
		
		
	}
	
	   private String generateAccountNumber()
	    {
	        Random random = new Random();
	        char letter = (char)('A' + random.nextInt(26));
	        Long number = 100000000+random.nextLong(899999999);
	        
	        return letter + String.valueOf(number);
	    }

}
