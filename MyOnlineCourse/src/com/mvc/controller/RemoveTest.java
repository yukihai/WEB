package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class RemoveTest
 */
@WebServlet("/RemoveTest")
public class RemoveTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int classid = Integer.parseInt(request.getParameter("classid"));
		int testid = Integer.parseInt(request.getParameter("testid"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		GetdataDAO get = new GetdataDAO();
		String result = get.RemoveTestFromClass(classid, testid);
		request.setAttribute("userid", userid);
		request.setAttribute("classid", classid);
		request.getRequestDispatcher("LoadList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
