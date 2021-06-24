package com.spring.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql.dao.SeriesRepo;
import com.spring.mysql.model.Series;


@RestController
public class SeriesController {
	
	@Autowired
	SeriesRepo repo;
	
	@PostMapping(path = "/addSeries")
	public Series addSeries(@RequestBody Series series) {
		repo.save(series);
		return series;
	}
	
	@GetMapping(path = "/series") 
	public List<Series> getSeries() {
		
		return repo.findAll();
	}
	
	@GetMapping("/series/id/{id}")
	public Optional<Series> getSeries(@PathVariable("id") int id) {
		return repo.findById(id);
	}
	
	@GetMapping("/series/name/{name}")
	public Optional<Series> getSeriesByName(@PathVariable("name") String name) {
		return repo.findByName(name);
	}
	
	@PutMapping(path = "/update")
	public Series saveOrUpdateSeries(@RequestBody Series series) {
		repo.deleteById(series.getId());
		repo.save(series);
		return series;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAlien(@PathVariable("id") int id) {
		Series a = repo.getOne(id);
		repo.delete(a);
		return "Series Removed ! "+ id;
	}
}
