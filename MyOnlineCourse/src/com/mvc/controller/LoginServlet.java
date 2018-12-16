package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UserBean;
import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
		GetdataDAO get = new GetdataDAO();
		UserBean result = get.GetAccount(username,password);
		if(result != null)
		{
			request.setAttribute("userid", result.getUserid());
			request.setAttribute("level", result.getLevel());
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message", username + " " + password);
			request.getRequestDispatcher("login.html").forward(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
