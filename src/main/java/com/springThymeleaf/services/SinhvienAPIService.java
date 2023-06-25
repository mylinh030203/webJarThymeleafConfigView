package com.springThymeleaf.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springThymeleaf.models.Sinhvien;

import io.micrometer.core.ipc.http.HttpSender.Response;

@Service
public class SinhvienAPIService {
	public List<Sinhvien> getDataFromAPI() throws JsonMappingException, JsonProcessingException {
		String apiURL = "http://localhost:8080/api/sinhvien";
		RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<String> response = restTemplate.getForEntity(apiURL, String.class);
		    String json = response.getBody();

		    ObjectMapper objectMapper = new ObjectMapper();
		    List<Sinhvien> svSinhvien = objectMapper.readValue(json, new TypeReference<List<Sinhvien>>() {});

		    return svSinhvien;
	}

}
