package com.surveyN.survey;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.surveyN.survey.model.SurveyDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SurveyApplicationTests {
	TestRestTemplate template = new TestRestTemplate();
	
	@LocalServerPort
	int port;
	
	@Test
	public void createSurvey_andCheckId() throws Exception {
		SurveyDAO dao = saveSurvey();
		findByIdProduct(dao.getId());
	}

	private SurveyDAO saveSurvey() {
		SurveyDAO dao = new SurveyDAO();
		dao.setTitle("new survey test");

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<SurveyDAO> entity = new HttpEntity<SurveyDAO>(dao, headers);

		ResponseEntity<SurveyDAO> response = template.exchange("http://localhost:" + port + "/surveys", HttpMethod.POST, entity,
				SurveyDAO.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		assertThat(!response.getBody().getId().isEmpty());
		return response.getBody();
	}
	
	private void findByIdProduct(String id) {
		try {
			ResponseEntity<SurveyDAO> response= template.getForEntity(new URI("http://localhost:" + port + "/surveys/" + id), SurveyDAO.class);
			assertThat(response.getStatusCode().is2xxSuccessful());
			assertThat(!response.getBody().getId().isEmpty());
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
