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
 * Servlet implementation class EditTest
 */
@WebServlet("/EditTest")
public class EditTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		int testid = Integer.parseInt(request.getParameter("testid"));
		GetdataDAO get = new GetdataDAO();
		AddDAO add = new AddDAO();
		String result="";
		switch(action)
		{
			case "1":
			{
				int courseid = Integer.parseInt(request.getParameter("courseid"));
				int questionid = Integer.parseInt(request.getParameter("questionid"));
				result = add.AddQuestionToTest(testid, courseid, questionid); break;
			}
			case "2":
			{
				int stt = Integer.parseInt(request.getParameter("stt"));
				result = get.RemoveQuestionFromTest(testid, stt); break;
			}
		}
		if(result.equals("SUCCESS"))
		{
			request.setAttribute("testid", testid);
			request.getRequestDispatcher("ShowQuestionInTest").forward(request, response);
		}
		else
		{
			response.getWriter().print("Fail!");
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
