package com.miraz.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.miraz.demo.Alien;

public interface RepoDao extends CrudRepository<Alien, Integer>{
	public List<Alien> findByAname(String a);
}
