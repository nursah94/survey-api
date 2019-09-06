package com.surveyN.survey.model;

import java.util.List;

public class SurveyCreateRequestDTO {
	private String title;
	private List<String> options;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	
	public String getOptionsAsString() {
		String donus = "";
		for(String option:options) {
			donus +=option+",";
		}
		return donus;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}

}
