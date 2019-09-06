
package com.surveyN.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveyN.survey.model.SurveyDAO;
import com.surveyN.survey.repository.SurverRepository;

@Service
public class SurveyService {
	@Autowired
	SurverRepository repo; // SurverRepository = repo yapmak icin
	
	public SurveyDAO create(SurveyDAO dto) {
		SurveyDAO dao = new SurveyDAO(); // disardan gelenleri kaydetmek icin db obje
		dao.setOptions(dto.getOptions()); // geleni (request dto yu daoYa cevirir.)
		dao.setTitle(dto.getTitle());

		SurveyDAO idlidao = repo.save(dao); // objede bisey degisirse return ediyor.

		return idlidao;
	}
	
	public SurveyDAO findById(String id) {
		System.out.println("id = " + id);
		return repo.findById(id).get();
	}
	
	public Iterable<SurveyDAO> findAll() {
		return repo.findAll();
	}
	
	public SurveyDAO update(SurveyDAO requestDAO, String id) {
		SurveyDAO dbdekiDAO;
		dbdekiDAO = repo.findById(id).get(); // dbeki. disardaki requestDAO. idden obje buluor. idli kisim dbde buldugum
												// obje. onada isim veriyom göstermek icin. dbdekiDAO objeyi göstermek
												// icin referans.
		// SurveyDAO dbdekiDAO = repo.findById(requestDAO.getId()).get(); //dbeki.
		// disardaki requestDAO. repodan id bulup realDAO degiskene ata. referans
		// surveyDAO elimiz de dbdekidao. arac
		dbdekiDAO.setOptions(requestDAO.getOptions()); // PUT
		dbdekiDAO.setTitle(requestDAO.getTitle()); // PUT ediyor.
		dbdekiDAO = repo.save(dbdekiDAO); // objede bisey degisirse return ediyor.
		return dbdekiDAO;
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
}
