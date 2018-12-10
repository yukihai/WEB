package com.mvc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.QuestionBean;
import com.mvc.dao.AddDAO;
import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt((String)request.getParameter("userid"));
		int classid = Integer.parseInt((String)request.getParameter("classid"));
		int	testid = Integer.parseInt((String)request.getParameter("testid"));
		int quantity = Integer.parseInt((String)request.getParameter("quantity"));
		GetdataDAO getdata = new GetdataDAO();
		AddDAO add = new AddDAO();
		String kt = add.AddCurrentQuiz(userid, testid, classid);
		String[] TestInfo = getdata.GetTestInfo(testid);
		int courseid=Integer.parseInt(TestInfo[0]);
		QuestionBean result = getdata.GetQuestion(testid, courseid, 0);
		if(result != null) 
		{
			request.setAttribute("Question", result.getQuestcontent());
			request.setAttribute("yourtime", TestInfo[1]);
			String[] answers = getdata.GetAnswers(result.getQuestionid());
			request.setAttribute("A", answers[0]);
			request.setAttribute("B", answers[1]);
			request.setAttribute("C", answers[2]);
			request.setAttribute("D", answers[3]);
			request.setAttribute("previoustime", null);
			request.setAttribute("userid", userid);
			request.setAttribute("testid", testid);
			request.setAttribute("quantity", quantity);
			request.setAttribute("courseid", TestInfo[0]);
			request.setAttribute("classid", classid);
			request.setAttribute("questionid", result.getQuestionid());
			request.setAttribute("stt", 0);
			request.getRequestDispatcher("Lambaithi.jsp").forward(request, response);
		}
		else
		{
			response.getWriter().println("Error!");
		}
	}

}
