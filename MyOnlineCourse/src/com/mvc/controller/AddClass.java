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
 * Servlet implementation class AddClass
 */
@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int teacherid = Integer.parseInt(request.getParameter("userid"));
		int level =  Integer.parseInt(request.getParameter("level"));
		String action = request.getParameter("action");
		AddDAO add = new AddDAO();
		String result=null;
		switch(action)
		{
			case "1": 
				{
					String classname = request.getParameter("classname");
					result = add.AddNewClass(teacherid, classname); break;
				}
			case "2":
			{
				int classid = Integer.parseInt(request.getParameter("oldclassid"));
				GetdataDAO get = new GetdataDAO();
				result = get.RemoveClass(classid);
				if(result.equals("SUCCESS"))
				{
					result = get.RemoveAllStudentFromClass(classid);
					if(result.equals("SUCCESS")) result = get.RemoveAllTestFromClass(classid);
				} break;
			}
			default: break;
		}
		String message = "";
		if(result.equals("SUCCESS"))
		{
			message="SUCCESS";
			request.setAttribute("level", level);
			request.setAttribute("userid", teacherid);
			request.setAttribute("message", message);
			request.getRequestDispatcher("LoadClass").forward(request, response);
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
