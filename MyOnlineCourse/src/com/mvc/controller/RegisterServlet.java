package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UserBean;
import com.mvc.dao.AddDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String level = request.getParameter("level");
		String message="";
		String color="red";
		if(password.equals(password2))
		{
			AddDAO add = new AddDAO();
			UserBean user = new UserBean();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setLevel("1");
			String result = add.AddNewUser(user);
			if(result.equals("SUCCESS"))
			{
				color="green";
				message="Register success";
				request.setAttribute("color", color);
				request.setAttribute("message", message);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else
			{
				message="Register fail";
			}
		}
		else
		{
			message="Wrong confirm password";
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
