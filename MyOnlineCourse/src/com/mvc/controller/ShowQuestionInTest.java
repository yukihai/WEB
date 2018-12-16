package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class ShowQuestionInTest
 */
@WebServlet("/ShowQuestionInTest")
public class ShowQuestionInTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestionInTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int testid = Integer.parseInt(request.getParameter("testid"));
		GetdataDAO get = new GetdataDAO();
		String[][] questions = get.GetQuestionFromTest(testid);
		String text="";
		text+="<table border = 2><tr><th>STT</th><th>Nội dung</th><th></th></tr>";
		int i=0;
		while(questions[i][0]!=null)
		{
			text+="<tr><td>"+questions[i][0]+"</td><td>"+questions[i][1]+
					"</td><td class=\"mybt\"><button id=\"bt"+questions[i][0]+"\" value=\""+questions[i][0]+ "\" onclick=\"Remove('"+questions[i][0]+"')\">Xóa</button></td></tr>";
			i++;
		}
		text+="</table>";
		request.setAttribute("table",text);
		request.setAttribute("testid",testid);
		request.getRequestDispatcher("ShowQuestionFromTest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
