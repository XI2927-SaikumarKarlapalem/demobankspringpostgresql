package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.section;
import com.example.demo.repository.sectionrepository;
@Service
public class sectionservice {
	
	@Autowired
	sectionrepository sectionrepository;

	public String addsection(section section) 
	{
	     sectionrepository.save(section);
		return "section added";
	}

	public List<section> getallsections() 
	{
      List<section> sectionlist= sectionrepository.findAll();
		return sectionlist;	
		
	}
	
	public String updatesection(section section, int sectionid) {
		Optional<section> section1=sectionrepository.findById(sectionid);
		if(section1.isPresent()) {
			section1.get().setName(section.getName());
			
		
			sectionrepository.save(section1.get());
			return "section updated successfully";
		
		}
		else
		{
			return "section not found";
		}

	}

	public section geteachsection(int id) {
		Optional<section> m2=sectionrepository.findById(id);
		return m2.isPresent()?m2.get():null;
	}

	public String deletesection(int id) {
		Optional<section> section1=sectionrepository.findById(id);
		if(section1!=null) {
			
			sectionrepository.deleteById(id);
			return "section deleted successfully";
		}
		else {
			return "section not found";
		}
		
	}
	
	}

	




