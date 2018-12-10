package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class LoadClass
 */
@WebServlet("/LoadClass")
public class LoadClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int level = Integer.parseInt(request.getParameter("level"));
		GetdataDAO get = new GetdataDAO();
		String[][] result = new String[100][3];
		if(level==4)
		{
			result = get.GetClassListForTeacher(userid);
		}
		if(level==1)
		{
			result = get.GetClassListForStudent(userid);
		}
		String text="";
		text+="<table><tr><th>ClassID</th><th>ClassName</th><th>TeacherName</th></tr>";
		int i=0;
		while(result[i][0]!=null)
		{
			text+="<tr><td>"+result[i][0]+"</td><td>"+result[i][1]+"</td><td>"+result[i][2]+
					"</td><td><button id=\"bt"+result[i][0]+"\" value=\""+result[i][0]+ "\" onclick=\"ToClass('"+result[i][0]+"')\">Xem</button></td></tr>";
			i++;
		}
		text+="</table>";
		request.setAttribute("dslophoc", text);
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("MyClass.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
