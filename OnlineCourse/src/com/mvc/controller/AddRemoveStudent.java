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
 * Servlet implementation class AddRemoveStudent
 */
@WebServlet("/AddRemoveStudent")
public class AddRemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRemoveStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int teacherid = Integer.parseInt(request.getParameter("userid"));
		int classid = Integer.parseInt(request.getParameter("classid"));
		String action = request.getParameter("action");
		AddDAO add = new AddDAO();
		GetdataDAO get = new GetdataDAO();
		String result=null;
		switch(action)
		{
			case "1": 
				{
					int studentid = Integer.parseInt(request.getParameter("newstudentid"));
					result = add.AddStudentToClass(classid, studentid); break;
				}
			case "2": 
				{
					int studentid = Integer.parseInt(request.getParameter("oldstudentid"));
					result = get.RemoveStudentFromClass(classid, studentid); break;
				}
			default: break;
		}
		String message = "";
		if(result.equals("SUCCESS"))
		{
			message="SUCCESS";
			request.setAttribute("userid", teacherid);
			request.setAttribute("message", message);
			request.getRequestDispatcher("LoadStudentInClass").forward(request, response);
		}
		else
		{
			response.getWriter().print("Fail");;
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
