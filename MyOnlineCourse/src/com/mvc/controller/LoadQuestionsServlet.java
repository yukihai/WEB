package com.mvc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.AnswerBean;
import com.mvc.bean.QuestionBean;
import com.mvc.dao.AddDAO;
import com.mvc.dao.GetdataDAO;

/**
 * Servlet implementation class LoadQuestionsServlet
 */
@WebServlet("/LoadQuestionsServlet")
public class LoadQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String previoustime = request.getParameter("previoustime");
		AddDAO add = new AddDAO();
		GetdataDAO getdata = new GetdataDAO();
		int yourtime = Integer.parseInt(request.getParameter("yourtime"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		int testid = Integer.parseInt(request.getParameter("testid"));
		int classid = Integer.parseInt((String)request.getParameter("classid"));
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		int stt = Integer.parseInt(request.getParameter("stt"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String button = request.getParameter("go");
		if(request.getParameter("answer") != null && request.getParameter("questionid") != null)
		{
			int answerid = Integer.parseInt(request.getParameter("answer"));
			int questionid = Integer.parseInt(request.getParameter("questionid"));
			String res = add.SaveAnswer(userid, testid, questionid, answerid);
		}
		if(button != null)
		{
			if(button.equals("1")) 
			{
				if(stt<=quantity)
				{
					stt++;
				}
				if(stt==quantity)
				{
					request.setAttribute("yourtime", yourtime);
					request.setAttribute("previoustime", previoustime);
					request.setAttribute("userid", userid);
					request.setAttribute("testid", testid);
					request.setAttribute("courseid", courseid);
					request.setAttribute("quantity", quantity);
					request.setAttribute("classid", classid);
					request.setAttribute("stt", stt);
					request.getRequestDispatcher("Lambaithi.jsp").forward(request, response);
				}
				if(stt>quantity)
				{
					int point = getdata.GetCorrectAnswers(userid, testid,classid) * (10/quantity);
					String record = Integer.toString(point);
					String update = add.SaveResult(userid, testid, classid, point);
					if(update!=null)
					{
						getdata.DeleteCurrentQuiz(userid, testid, classid);
						request.setAttribute("point", record);
						String[][] info = null;
						info = getdata.GetResultInfo(userid, testid, classid);
						if(info[0][0]!=null)
						{
							request.setAttribute("title", info[0][0]);
							request.setAttribute("username", info[0][1]);
							request.setAttribute("classname", info[0][2]);
							request.getRequestDispatcher("Result.jsp").forward(request, response);
						}
						else
						{
							response.getWriter().print("Error");
						}
					}
					else
					{
						response.sendRedirect("Notice.jsp");
					}
				}
			}
			else 
			{
				if(stt > 0)
				{
					stt--;
				}
				else
				{
					stt=0;
				}
			}
		}
		QuestionBean result = getdata.GetQuestion(testid, courseid, stt);
		if(result != null) 
		{
			String ans = getdata.GetUserAnswer(userid, testid, result.getQuestionid());
			request.setAttribute("checked", ans);
			request.setAttribute("Question", result.getQuestcontent());
			request.setAttribute("yourtime", yourtime);
			String[] answers = getdata.GetAnswers(result.getQuestionid());
			request.setAttribute("A", answers[0]);
			request.setAttribute("B", answers[1]);
			request.setAttribute("C", answers[2]);
			request.setAttribute("D", answers[3]);
			request.setAttribute("previoustime", previoustime);
			request.setAttribute("userid", userid);
			request.setAttribute("testid", testid);
			request.setAttribute("classid", classid);
			request.setAttribute("courseid", courseid);
			request.setAttribute("quantity", quantity);
			request.setAttribute("questionid", result.getQuestionid());
			request.setAttribute("stt", stt);
			request.getRequestDispatcher("Lambaithi.jsp").forward(request, response);
		}
		else
		{
			response.getWriter().println("Error!");
		}
	}
}
