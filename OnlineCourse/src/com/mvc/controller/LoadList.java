package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class LoadList
 */
@WebServlet("/LoadList")
public class LoadList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		int level = Integer.parseInt(request.getParameter("level"));
		GetdataDAO get = new GetdataDAO();
		String[][] result = null;
		if(level==1)
		{
			int classid= Integer.parseInt(request.getParameter("classid"));
			result = get.GetTestList(classid);
			request.setAttribute("classid", classid);
		}
		if(level==3)
		{
			result = get.GetAllTest();
		}
		String text="";
		text+="<table><tr><th>TestID</th><th>Title</th><th>CourseName</th><th>Quantity</th><th>Time</th><th>Author</th><th></th></tr>";
		int i=0;
		while(result[i][0]!=null)
		{
			text+="<tr><td>"+result[i][0]+"</td><td>"+result[i][1]+"</td><td>"+result[i][2]+"</td><td>"+result[i][3]+"</td><td>"+result[i][4]+"</td><td>"+result[i][5]+
					"</td><td><button id=\"bt"+result[i][0]+"\" value=\""+result[i][0]+ "\" onclick=\"DoTest('"+result[i][0]+"','"+result[i][3]+"')\">Làm bài</button></td></tr>";
			i++;
		}
		text+="</table>";
		request.setAttribute("table", text);
		request.setAttribute("userid", userid);
		if(level==1)
		{
			request.getRequestDispatcher("LoadTest.jsp").forward(request, response);
		}
		if(level==3)
		{
			request.getRequestDispatcher("TestControlPage.jsp").forward(request, response);
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
