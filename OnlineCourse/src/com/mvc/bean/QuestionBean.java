package com.mvc.bean;

public class QuestionBean {
	private int questionid;
	private int courseid;
	private String questcontent;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getQuestcontent() {
		return questcontent;
	}
	public void setQuestcontent(String questcontent) {
		this.questcontent = questcontent;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
}
