package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssFaceController {
	@Autowired
	RecordRepository recordRepository;

	@RequestMapping(value = "/assface",
			  method = RequestMethod.GET,
			  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String printAssFace(){

		RecordEntity entity = new RecordEntity();
		entity.setFirstName("fuck");
		entity.setLastName(("you"));
		recordRepository.save(entity);

		return new String();
	}


	@RequestMapping(value = "/assface/all",
			  method = RequestMethod.GET,
			  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<RecordEntity> printAllAsses(){
		return recordRepository.findAll();

	}


	@RequestMapping(value = "/stuff",
			  method = RequestMethod.GET,
			  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public RecordEntity printStuff(){
		RecordEntity entity = new RecordEntity();
		entity.setFirstName("wow");
		entity.setLastName(("doug"));

		return entity;
	}

//	@RequestMapping("/employee/add")
//	public ModelAndView add(
//			  @RequestParam(value = "firstName") String firstName,
//			  @RequestParam(value = "surName") String surName) {
//		//....
//		//....
//		return null;
//	}



	@RequestMapping(value = "/add",
			  method = RequestMethod.POST,
			  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public RecordEntity addStuff(
		@RequestBody RecordEntity entity) {


		//RecordEntity entity = new RecordEntity();
		entity.getFirstName();
		entity.getLastName();
		recordRepository.save(entity);
		return entity;
	}


}
