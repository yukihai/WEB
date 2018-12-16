package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.AnswerBean;
import com.mvc.bean.QuestionBean;
import com.mvc.bean.UserBean;
import com.mvc.util.DBConnection;

public class AddDAO {
	public String AddNewUser(UserBean userBean)
	{
		String userName = userBean.getUsername();
		String password = userBean.getPassword();
		String email = userBean.getEmail();
		String level = userBean.getLevel();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into users(UserID,UserName,Password,Email,Level) values(NULL,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, level);
			int i= preparedStatement.executeUpdate();
			if (i!=0) //Just to ensure data has been inserted into the database
				return "SUCCESS";
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";
	}
	public String AddNewQuestion(QuestionBean questionBean)
	{
		int courseid = questionBean.getCourseid();
		String questioncontent= questionBean.getQuestcontent();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into questions(QuestionID,CourseID,QuestionContent) values(NULL,?,?)";
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, courseid);
			preparedStatement.setString(2, questioncontent);
			int i= preparedStatement.executeUpdate();
			if (i!=0)
			{//Just to ensure data has been inserted into the database
				return "SUCCESS";
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!"; // On failure, send a message from here.
	}
	
	public String AddNewAnswer(int answerid,AnswerBean answerBean)
	{
		int questionid = answerBean.getQuestionid();
		String answercontent = answerBean.getAnswercontent();
		int correctanswer= answerBean.getCorrectanswer();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into answers(AnswerID,QuestionID,AnswerContent,CorrectAnswer) values(?,?,?,?)"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, answerid);
			preparedStatement.setInt(2, questionid);
			preparedStatement.setString(3, answercontent);
			preparedStatement.setInt(4, correctanswer);
			int i= preparedStatement.executeUpdate();
			if (i!=0)
			{//Just to ensure data has been inserted into the database
				return "SUCCESS";
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";
	}
	
	public String AddCurrentQuiz(int userid, int testid, int classid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into user_answers select ?, ?, ?, QuestionID, NULL from tests where TestID = ?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, userid);
			preparedStatement.setInt(2, testid);
			preparedStatement.setInt(3, classid);
			preparedStatement.setInt(4, testid);
			int result = preparedStatement.executeUpdate();
			if (result!=0)
			{//Just to ensure data has been inserted into the database
					return "SUCCESS";
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
			return e.getMessage();
		}
		return "Oops.. Something went wrong there..!";
	}
	
	public String SaveAnswer(int userid, int testid, int questionid, int answerid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "update user_answers set AnswerID=? where UserID=? and TestID=? and QuestionID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, answerid);
			preparedStatement.setInt(2, userid);
			preparedStatement.setInt(3, testid);
			preparedStatement.setInt(4, questionid);
			int result = preparedStatement.executeUpdate();
			if (result!=0)
			{//Just to ensure data has been inserted into the database
					return "SUCCESS";
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
			return e.getMessage();
		}
		return "Oops.. Something went wrong there..!";
	}
	
	public String AddNewTestInfo(int testid, String title, int courseid, int quantity, int period, int authorid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into test_info(TestID, Title, CourseID, Quantity, Period, AuthorID) values(?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, testid);
			preparedStatement.setString(2, title);
			preparedStatement.setInt(3, courseid);
			preparedStatement.setInt(4, quantity);
			preparedStatement.setInt(5, period);
			preparedStatement.setInt(6, authorid);
			int result = preparedStatement.executeUpdate();
			if (result!=0)
			{//Just to ensure data has been inserted into the database
				return "SUCCESS";
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";
	}
	
	public String AddNewTest(int testid, int courseID, int[] questIDs)
	{
		int i = 0;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			while(i < questIDs.length)
			{
				String query = "insert into tests(TestID, STT, CourseID, QuestionID) values(?,?,?,?)";
				preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
				preparedStatement.setInt(1, testid);
				preparedStatement.setInt(2, i);
				preparedStatement.setInt(3, courseID);
				preparedStatement.setInt(4, questIDs[i]);
				int result = preparedStatement.executeUpdate();
				if (result!=0)
				{//Just to ensure data has been inserted into the database
					i++;
				}
				else
				{
					break;
				}
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		if(i < questIDs.length)
		{
			return "Oops.. Something went wrong there..!";
		}
		else
		{
			return "SUCCESS";
		}
	}
	public String SaveResult(int userid, int testid, int classid, int point)
	{
		String result = null;
		Connection con = null;
		PreparedStatement statement = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("insert into records values(?,?,?,?)");
			statement.setInt(1, userid);
			statement.setInt(2, testid);
			statement.setInt(3, classid);
			statement.setInt(4, point);
			int i= statement.executeUpdate();
			if (i!=0) return "SUCCESS";
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String AddNewClass(int teacherid, String classname)
	{
		String result = null;
		Connection con = null;
		PreparedStatement statement = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("insert into classes values(NULL,?,?)");
			statement.setString(1, classname);
			statement.setInt(2, teacherid);
			int i= statement.executeUpdate();
			if (i!=0) return "SUCCESS";
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String AddTestToClass(int classid, int testid)
	{
		String result = null;
		Connection con = null;
		PreparedStatement statement = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("insert into class_test values(?,?)");
			statement.setInt(1, classid);
			statement.setInt(2, testid);
			int i= statement.executeUpdate();
			if (i!=0) return "SUCCESS";
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String AddStudentToClass(int classid, int studentid)
	{
		String result = null;
		Connection con = null;
		PreparedStatement statement = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("insert into student_class values(?,?)");
			statement.setInt(1, studentid);
			statement.setInt(2, classid);
			int i= statement.executeUpdate();
			if(i!=0) return "SUCCESS";
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String AddQuestionToTest(int testid, int courseid, int questionid)
	{
		String result = null;
		Connection con = null;
		PreparedStatement statement = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("insert into tests select ?,max(STT)+1,?,? from tests where TestID=?");
			statement.setInt(1, testid);
			statement.setInt(2, courseid);
			statement.setInt(3, questionid);
			statement.setInt(4, testid);
			int i= statement.executeUpdate();
			return "SUCCESS";
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
}
