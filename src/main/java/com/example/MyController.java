package com.example;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
	@Autowired
	RecordRepository recordRepository;

	@RequestMapping(value = "/dude",
			  method = RequestMethod.GET,
			  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String printEntity(){

		RecordEntity entity = new RecordEntity();
		entity.setFirstName("hey");
		entity.setLastName(("dude"));
		recordRepository.save(entity);

		//return "{\"hello\": \"world\"}";
		//return "{\" + getFirstName() + \":\" + getLastName() + \" + \"}";
		return "{\"FirstName\":\"" + entity.getFirstName() + "\",\"LastName\":\"" + entity.getLastName()  + "\"}";
	}


	@RequestMapping(value = "/all",
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


	@RequestMapping(value = "/updateOne/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public RecordEntity updateStuff(
		@PathVariable("id") ObjectId id, @RequestBody RecordEntity updateEntity) {

		RecordEntity newEntity = recordRepository.findOne(id.toString());

		newEntity.setFirstName(updateEntity.getFirstName());
		newEntity.setLastName(updateEntity.getLastName());

		recordRepository.save(newEntity);


		return newEntity;
	}

	@RequestMapping(value = "/add",
			  method = RequestMethod.POST,
			  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public RecordEntity addStuff(
		@RequestBody RecordEntity entity) {

		entity.getFirstName();
		entity.getLastName();
		recordRepository.save(entity);
		return entity;
	}

	@RequestMapping(value = "/findOne/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public RecordEntity findOneRecord(
			@PathVariable("id") ObjectId id) {

		String newId = id.toString();

		RecordEntity entity = recordRepository.findOne(newId);
		return entity;
	}

//	@RequestMapping(value = "/calc",
//			  method = RequestMethod.GET,
//			  produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(HttpStatus.OK)


	public int calcResult() {
		int myval = 6;
		return myval;
	}
}
