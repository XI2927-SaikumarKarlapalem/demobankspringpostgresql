package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.bank;
import com.example.demo.mathop.mathop;
import com.example.demo.repository.bankrepository;



@Service

public class bankservice {
	
	@Autowired
	bankrepository bankrepository;

	public String addbank(bank bank) 
	{
	     bankrepository.save(bank);
		return "bank added";
	}

	public List<bank> getallbanks(int pageno, int pagesize, String sortorder) 
	{
	    Pageable pageable=PageRequest.of(pageno, pagesize,sortorder.equals("asc") ? Sort.by("name").ascending():Sort.by("name").descending());
        Page<bank> banklist= bankrepository.findAll(pageable);
		return banklist.toList();
		
		
		
	}
	
	public String updatebank(bank bank, int bankid) {
		Optional<bank> bank1=bankrepository.findById(bankid);
		if(bank1.isPresent()) {
			bank1.get().setName(bank.getName());
			bank1.get().setLocation(bank.getLocation());
		
			bankrepository.save(bank1.get());
			return "bank updated successfully";
		
		}
		else
		{
			return "bank not found";
		}

	}

	public bank geteachbank(int id) {
		Optional<bank> m2=bankrepository.findById(id);
		return m2.isPresent()?m2.get():null;
	}
	
	
	public bank geteachbankname(String name ) {
		Optional<bank> m2=bankrepository.findByname(name);
		return m2.isPresent()?m2.get():null;
	}

	
	
	
	

	public String deletebank(int id) {
		Optional<bank> dep1=bankrepository.findById(id);
		if(dep1!=null) {
			
			bankrepository.deleteById(id);
			return "bank deleted successfully";
		}
		else {
			return "bank not found";
		}
		
	}

	public long getcountbyjpa() {
	return bankrepository.count();
	}

	public int getbankcount() {
		int count=bankrepository.getbankcount();
		return count;
	}
	
	
	public int add(int a,int b )
	{
		mathop obj=new mathop();
		return obj.add(a, b);
	}

	public int mul(int a, int b) {
	     mathop obj=new mathop();
	     return obj.add(a, b);
	}

	
  
	}

	

