package com.iii.eeit109.ajax;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateValidation")
public class DateValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DateValidation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean passed= validateDate(request.getParameter("birth"));
		response.getWriter().print(passed);
	}
	
	private boolean validateDate(String date) {
		boolean isValid=true;
		if(date !=null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			formatter.setLenient(false);
			try {
				formatter.parse(date);
			} catch (ParseException e) {
				System.out.println(e.toString());
				isValid=false;
			}
		}else
			isValid=false;
		return isValid;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
