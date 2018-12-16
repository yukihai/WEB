package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.AddDAO;
import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class TestControl
 */
@WebServlet("/TestControl")
public class TestControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		AddDAO add = new AddDAO();
		GetdataDAO get = new GetdataDAO();
		String result=null;
		switch(action)
		{
			case "1": 
				{
					int classid = Integer.parseInt(request.getParameter("selectedclassid"));
					int testid = Integer.parseInt(request.getParameter("selectedtestid"));
					result = add.AddTestToClass(classid,testid); break;
				}
			case "2": 
				{
					int testid = Integer.parseInt(request.getParameter("oldtestid"));
					result = get.RemoveTest(testid);
					result = get.RemoveTestInfo(testid);
				}
			default: break;
		}
		if(result.equals("SUCCESS"))
		{
			request.getRequestDispatcher("LoadList").forward(request, response);
		}
		else
		{
			response.getWriter().print("Fail");
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
