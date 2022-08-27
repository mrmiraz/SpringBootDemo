package com.miraz.demo;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.miraz.demo.dao.RepoDao;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
    RepoDao repo;
	@RequestMapping("home")
	public String home() {
		
		System.out.println("home");
//		System.out.println(repo.findByAname("miraz"));
		return "home.jsp";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
//		System.out.println(alien.getAid() + " "+ alien.getAname());
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAlien() {
		return (List)repo.findAll();
	}
	
	@RequestMapping("aliens/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
	@RequestMapping("aliens/{aname}")
	@ResponseBody
	public List<Alien> getAlien(@PathVariable("aname") String aname) {
		return repo.findByAname(aname);
	}
	
}
