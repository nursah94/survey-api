package com.surveyN.survey.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class SurveyDAO {
	@Id
	private String id;
	
	private String title;
	private List<String> options;
	private List<SurveyAnswer> answers; //cevaplayan user
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
}
