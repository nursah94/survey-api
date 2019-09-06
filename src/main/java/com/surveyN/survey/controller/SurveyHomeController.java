package com.surveyN.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyN.survey.model.SurveyDAO;
import com.surveyN.survey.repository.SurverRepository;

@RestController 
@RequestMapping("/surveys")
public class SurveyHomeController {
	@Autowired
	SurverRepository repo;


//	@GetMapping("/random")
//	public List<SurveyDAO> randomSurveys(@PathVariable String limit) { 
//		long count = repo.count();
//	}

}
// restcontroller requesetmappin annotationarini koy, repoyu autowire et
// getmappingli method ekle
// bu method repodan 5 tane dao ceksin,spring crud repodan limit 5li nasil
// cekilir
