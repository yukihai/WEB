package com.mvc.controller;

import java.io.IOException;
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
 * Servlet implementation class AddQuestionsServlet
 */
@WebServlet("/AddQuestionsServlet")
public class AddQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Copying all the input parameters in to local variables
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		String questioncontent = request.getParameter("questioncontent");
		QuestionBean questionBean = new QuestionBean();
		//Using Java Beans - An easiest way to play with group of related data
		questionBean.setCourseid(courseid);
		questionBean.setQuestcontent(questioncontent);
		AddDAO addDao = new AddDAO();
		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		String addquestionResult = addDao.AddNewQuestion(questionBean);
		if(addquestionResult.equals("SUCCESS")) 
		{//On success, you can display a message to user on Home page
			GetdataDAO getDao = new GetdataDAO();
			int questionid = getDao.GetCurrentQuestionID();
			String[] answercontent = {request.getParameter("answerA"), request.getParameter("answerB"), request.getParameter("answerC"), request.getParameter("answerD")};
			int correctanswer = Integer.parseInt(request.getParameter("correctanswer"));
			int n = 0;
			for(int i = 0; i < 4; i++)
			{
				AnswerBean answerBean = new AnswerBean();
				answerBean.setQuestionid(questionid);
				answerBean.setAnswercontent(answercontent[i]);
				if(i == correctanswer) 
				{
					answerBean.setCorrectanswer(1);
				}
				else 
				{
					answerBean.setCorrectanswer(0);
				}
				String addanswerResult = addDao.AddNewAnswer(i+1,answerBean);
				if(addanswerResult.equals("SUCCESS")) n++;
				else
				{
					break;
				}
			}
			if(n == 4)
			{
				response.getWriter().print("Add new question and answers completed!");
			}
			else
			{
				response.getWriter().print("Fail to add new answers!");
			}
		}
		else //On Failure, display a meaningful message to the User.
		{
			response.getWriter().print("Fail to add new question!");
		}
	}

}
