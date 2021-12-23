package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.section;

import com.example.demo.repository.sectionrepository;
import com.example.demo.service.sectionservice;


	

@RestController
@RequestMapping("/api")
public class sectioncontroller 
{
	@Autowired
	sectionservice sectionservice;
	
	@Autowired
	sectionrepository sectionrepository;
	
	@PostMapping("/section")
	public  String addsection(@RequestBody section section)
	{
		String m1=sectionservice.addsection(section);
		System.out.println(sectionrepository);
		return m1;
	}
	@GetMapping("/section")
	public List<section> getallsections()
	{
	   List<section> sectionlist=sectionservice.getallsections();	
	   return sectionlist;
	}
	@GetMapping("/section/{id}")
	public section geteachsection(@PathVariable("id") int id)
	{
		section m2=sectionservice.geteachsection(id);
		return m2;
	}
	
	
	
	@PutMapping("section/{id}")
	public String updatesection(@RequestBody section section,@PathVariable("id") int sectionid)
	{
		String message=sectionservice.updatesection(section,sectionid);
		return message;
	}
	
	@DeleteMapping("section/{id}")
	public String deletesection(@PathVariable("id") int id)
	{
		String message=sectionservice.deletesection(id);
		return message;
	}
}




