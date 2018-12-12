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
 * Servlet implementation class AddNewTest
 */
@WebServlet("/AddNewTest")
public class AddNewTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		int authorid=Integer.parseInt(request.getParameter("userid"));
		int period=Integer.parseInt(request.getParameter("period"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		GetdataDAO get = new GetdataDAO();
		AddDAO set = new AddDAO();
		int testid = get.GetNextTestID();
		if(testid > 0)
		{
			String result = set.AddNewTestInfo(title, courseid, quantity, period, authorid);
			if(result.equals("SUCCESS"))
			{
				int[] questionIDs = get.GetRandomQuestions(quantity,courseid);
				result = set.AddNewTest(testid, courseid, questionIDs);
				if(result.equals("SUCCESS"))
				{
					request.setAttribute("message", "Add new test completed");
				}
				else
				{
					request.setAttribute("message","Fail to add random questions!");
				}
			}
			else
			{
				request.setAttribute("message","Fail to add test info!");
			}
		}
		else
		{
			request.setAttribute("message","Get TestID Fail!");
		}
		request.setAttribute("userid", authorid);
		request.getRequestDispatcher("MakeNewTest.jsp").forward(request, response);
	}

}
