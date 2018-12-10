package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class LoadStudentInClass
 */
@WebServlet("/LoadStudentInClass")
public class LoadStudentInClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadStudentInClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		int classid= Integer.parseInt(request.getParameter("classid"));
		GetdataDAO get = new GetdataDAO();
		String[][] result = get.GetStudentFromClass(classid);
		String text="";
		text+="<table><tr><th>StudentID</th><th>StudentName</th></tr>";
		int i=0;
		while(result[i][0]!=null)
		{
			text+="<tr><td>"+result[i][0]+"</td><td>"+result[i][1]+"</td></tr>";
			i++;
		}
		text+="</table>";
		request.setAttribute("dssv", text);
		request.setAttribute("classid", classid);
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("CurrentClass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
