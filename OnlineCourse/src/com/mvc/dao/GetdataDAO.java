package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.AnswerBean;
import com.mvc.bean.QuestionBean;
import com.mvc.bean.UserBean;
import com.mvc.util.DBConnection;

public class GetdataDAO {
	public int GetCurrentQuestionID()
	{
		int result = -1;
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.createStatement(); //Statement is used to write queries. Read more about it.
			resultSet = statement.executeQuery("select max(QuestionID) as Result from questions");
			while(resultSet.next())
			{
				result = resultSet.getInt("Result");
				if(result != 0)
				{
					return result;
				}
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return -1;
	}
	public QuestionBean GetQuestion(int testid, int courseid, int stt)
	{
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		QuestionBean result = new QuestionBean();
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select tests.QuestionID, QuestionContent from questions, tests where questions.QuestionID = tests.QuestionID and TestID = ? and tests.CourseID = ? and STT = ?");
			statement.setInt(1, testid);
			statement.setInt(2, courseid);
			statement.setInt(3, stt);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result.setQuestionid(resultSet.getInt("QuestionID"));
				result.setCourseid(courseid);
				result.setQuestcontent(resultSet.getString("QuestionContent"));
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return null;
	}
	
	public String[] GetAnswers(int questionID)
	{
		String[] result = new String[4];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select AnswerContent from answers where QuestionID = ?");
			statement.setInt(1, questionID);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i]=resultSet.getNString("AnswerContent");
				i++;
			}
			return result;
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return null;
	}
	
	public int[] GetRandomQuestions(int num, int courseid)
	{
		int[] result = new int[num];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("SELECT * FROM questions WHERE CourseID=? ORDER BY RAND() LIMIT ?");
			statement.setInt(1, courseid);
			statement.setInt(2, num);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i]=resultSet.getInt("QuestionID");
				i++;
			}
			return result;
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return null;
	}
	
	public int GetNextTestID()
	{
		int result;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select max(TestID) as NextID from tests");
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result = resultSet.getInt("NextID") + 1;
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return -1;
	}
	
	public UserBean GetAccount(String username, String password)
	{
		UserBean result = new UserBean();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select * from users where UserName=? and Password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result.setUserid(resultSet.getString("UserID"));
				result.setLevel(resultSet.getString("Level"));
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return null;
	}
	
	public int GetMaxSTT(int testid)
	{
		int result;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select count(TestID) as MAXSTT from tests where TestID=?");
			statement.setInt(1, testid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result = resultSet.getInt("MAXSTT");
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return -1;
	}
	public String[][] GetAllTest()
	{
		String[][] result = new String[100][6];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select A.TestID, Title, CourseName, Quantity, Period, UserName from test_info A, courses B, users C where A.CourseID = B.CourseID and A.AuthorID = C.UserID");
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i][0] = resultSet.getString("TestID");
				result[i][1] = resultSet.getString("Title");
				result[i][2] = resultSet.getString("CourseName");
				result[i][3] = resultSet.getString("Quantity");
				result[i][4] = resultSet.getString("Period");
				result[i][5] = resultSet.getString("UserName");
				i++;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String[][] GetTestList(int classid)
	{
		String[][] result = new String[100][6];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select A.TestID, Title, CourseName, Quantity, Period, UserName from test_info A, courses B, users C, class_test D where A.CourseID = B.CourseID and A.AuthorID = C.UserID and A.TestID = D.TestID and D.ClassID = ?");
			statement.setInt(1, classid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i][0] = resultSet.getString("TestID");
				result[i][1] = resultSet.getString("Title");
				result[i][2] = resultSet.getString("CourseName");
				result[i][3] = resultSet.getString("Quantity");
				result[i][4] = resultSet.getString("Period");
				result[i][5] = resultSet.getString("UserName");
				i++;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String[][] GetClassListForStudent(int userid)
	{
		String[][] result = new String[100][3];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select distinct A.ClassID,ClassName,UserName from classes A, users B, student_class C where A.TeacherID = B.UserID and A.ClassID=C.ClassID and C.StudentID=?");
			statement.setInt(1, userid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i][0] = resultSet.getString("ClassID");
				result[i][1] = resultSet.getString("ClassName");
				result[i][2] = resultSet.getString("UserName");
				i++;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String[][] GetClassListForTeacher(int userid)
	{
		String[][] result = new String[100][3];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select distinct A.ClassID,ClassName,UserName from classes A, users B where A.TeacherID = B.UserID and A.TeacherID=?");
			statement.setInt(1, userid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i][0] = resultSet.getString("ClassID");
				result[i][1] = resultSet.getString("ClassName");
				result[i][2] = resultSet.getString("UserName");
				i++;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	
	public String[] GetTestInfo(int testid)
	{
		String[] result = new String[2];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select CourseID, Period from test_info where TestID=?");
			statement.setInt(1, testid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[0] = resultSet.getString("CourseID");
				result[1] = resultSet.getString("Period");
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String GetUserAnswer(int userid, int testid, int questionid)
	{
		String result = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select AnswerID from user_answers where UserID=? and TestID=? and QuestionID=?");
			statement.setInt(1, userid);
			statement.setInt(2, testid);
			statement.setInt(3, questionid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result= resultSet.getString("AnswerID");
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public int GetCorrectAnswers(int userid, int testid, int classid)
	{
		int result = -1;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select count(A.QuestionID) as Result from user_answers A, answers B where A.AnswerID = B.AnswerID and A.QuestionID = B.QuestionID and B.CorrectAnswer=1 and A.UserID=? and A.TestID=? and A.ClassID=?");
			statement.setInt(1, userid);
			statement.setInt(2, testid);
			statement.setInt(3, classid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result= resultSet.getInt("Result");
				return result;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
	public String DeleteCurrentQuiz(int userid, int testid, int classid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from user_answers where UserID=? and TestID=? and ClassID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, userid);
			preparedStatement.setInt(2, testid);
			preparedStatement.setInt(3, classid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String RemoveTestFromClass(int classid, int testid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from class_test where ClassID=? and TestID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, classid);
			preparedStatement.setInt(2, testid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String RemoveStudentFromClass(int classid, int studentid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from student_class where ClassID=? and StudentID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, classid);
			preparedStatement.setInt(2, studentid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	
	public String RemoveTestInfo(int testid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from test_info where ClassID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, testid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String RemoveTest(int testid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from tests where TestID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, testid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	
	public String RemoveTestClass(int testid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from class_test where TestID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, testid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String RemoveClass(int classid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from classes where ClassID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, classid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String RemoveAllStudentFromClass(int classid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from student_class where ClassID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, classid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String RemoveAllTestFromClass(int classid)
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "delete from class_test where ClassID=?"; 
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1, classid);
			int result = preparedStatement.executeUpdate();
			if (result>=0)
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
	public String[][] GetStudentFromClass(int classid)
	{
		String[][] result = new String[100][2];
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try
		{
			con = DBConnection.createConnection(); //establishing connection
			statement = con.prepareStatement("select A.StudentID, B.UserName from student_class A, users B where A.studentID=B.UserID and A.ClassID=?");
			statement.setInt(1, classid);
			resultSet = statement.executeQuery(); //Here table name is users and userName,password are columns.resultSet.
			int i = 0;
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				result[i][0] = resultSet.getString("StudentID");
				result[i][1] = resultSet.getString("UserName");
				i++;
			}
		}
		catch(SQLException e)
		{ 
			e.printStackTrace();
		}
		return result;
	}
}
