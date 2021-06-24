package com.spring.mysql.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mysql.model.Series;

public interface SeriesRepo extends JpaRepository<Series, Integer>{

	Optional<Series> findByName(String name);

}
