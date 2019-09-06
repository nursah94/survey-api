package com.surveyN.survey.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveyN.survey.model.SurveyCreateRequestDTO;
import com.surveyN.survey.model.SurveyCreateResponseDTO;
import com.surveyN.survey.model.SurveyDAO;
import com.surveyN.survey.repository.SurverRepository;
import com.surveyN.survey.service.SurveyService;

@RestController // gelen json bodyi objeye çevirir
@RequestMapping("${surveys-path.a}")
public class SurveyController { // tum apileri buraya sadece yaz bu classa
	
	@Autowired
	SurveyService service;
	
	// yeni olustururken
	@PostMapping // methoda post request atabilmeyi sagliyor. parantez icinde bisiy yazarsam urlde altina ekliyor
	public SurveyDAO createSurvey(@RequestBody SurveyDAO dto) { // Gelen body'yi, SurveyCRDTO mapper'ina uygun olarak parse edip, objeye cevirip, dto referansinaatar. void yerine
																							// SurveyCreateResponseDTO
																							// yazdik donen o cunku
		return service.create(dto);
	}

	@GetMapping("/{id}")
	public SurveyDAO getSurvey(@PathVariable String id) { // yukardaki id yi koda getrimek icin annotation
		return service.findById(id);
	}

	@GetMapping
	public Iterable<SurveyDAO> getAll() { // SurveyDAO db'e kaydettign pbje
		return service.findAll();
	}

	// PUT
	@PutMapping("{id}")
	public SurveyDAO updateOne(@RequestBody SurveyDAO requestDAO, @PathVariable String id) { // annotation disardan
																								// gelen bodyi
																								// surveyDAOya mapliyor
		return service.update(requestDAO, id);
	}

	@DeleteMapping("{id}") // request body olmd icin id eklemeli
	public void delete(@PathVariable String id) { // pathdeki id degisken olan idye setliyor
		service.delete(id);
	}

	

}
