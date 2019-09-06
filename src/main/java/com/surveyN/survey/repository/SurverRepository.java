package com.surveyN.survey.repository;

import org.springframework.data.repository.CrudRepository;

import com.surveyN.survey.model.SurveyAnswer;
import com.surveyN.survey.model.SurveyDAO;
import java.lang.String;
import java.util.List;

public interface SurverRepository extends CrudRepository<SurveyDAO, String>{
	List<SurveyDAO> findByTitle(String title);
	//findByAnswersNotContains(SurveyAnswer answer)
}
