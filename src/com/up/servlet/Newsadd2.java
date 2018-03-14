package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Newsadd2
 */
@WebServlet("/Newsadd2")
public class Newsadd2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newsadd2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String issuer=request.getParameter("issuer");
		 String time=request.getParameter("time");
		 String state=request.getParameter("state");
		 String title=request.getParameter("title");
		 String message=request.getParameter("message");;
	     String kind=request.getParameter("kind");
		 String url1=request.getParameter(" url1");
		 String url2=request.getParameter("url2");
		 String cid=request.getParameter("cid");
		 System.out.println("issuer=" + issuer + ", time=" + time + ", state=" + state + ", title=" + title
			+ ", message=" + message + ", kind=" + kind + ", url1=" + url1 + ", url2=" + url2 + ", cid=" +cid);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
