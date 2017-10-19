package com.ibm.jp.jfeso;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClockApp
 */
@WebServlet("/ClockApp")
public class ClockApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static long refNumber = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClockApp() {
        super();
        refNumber++;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		java.util.Date date = new java.util.Date(118, 1, 1);
		javax.servlet.RequestDispatcher dsp = request.getRequestDispatcher("/now.jsp");
		javax.servlet.http.HttpSession sess = request.getSession(true);
		sess.setAttribute("date", date);
		sess.setAttribute("caller", this);
		refNumber++;
		dsp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public long getRefNumber() {
		return refNumber++;
	}
}
