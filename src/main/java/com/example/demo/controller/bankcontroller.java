package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.bank;
import com.example.demo.repository.bankrepository;
import com.example.demo.service.bankservice;






@RestController
@RequestMapping("/api")
public class bankcontroller {
	@Autowired
	bankservice bankservice;
	
	@Autowired
	bankrepository bankrepository;
	
	@PostMapping("/bank")
	public ResponseEntity <String> addbank(@RequestBody bank bank)
	{
		String m1=bankservice.addbank(bank);
		System.out.println(bankrepository);
		return ResponseEntity.status(HttpStatus.CREATED).body(m1);
		
	}
	
	@GetMapping("/bank/{pageno}/{pagesize}/{order}")
	public List<bank> getallbanks(@PathVariable("pageno") int pageno,@PathVariable("pagesize") int pagesize,@PathVariable("order")String sortorder)
	{
	   List<bank> banklist=bankservice.getallbanks(pageno,pagesize,sortorder);	
	   return banklist;
	}
	
	//@GetMapping("/bank")
	//public List<bank>getallbanks()
	//{
	//	List<bank>banklist=bankservice.getallbanks();
	//	return banklist;
	//}
	@GetMapping("/bank/{id}")
	public ResponseEntity <bank> geteachbank(@PathVariable("id") int id)
	{
		bank m2=bankservice.geteachbank(id);
		if(m2!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(m2);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(m2);
	}
		
		
	}
	
	@GetMapping("/bank/byname/{name}")
	public ResponseEntity <bank> geteachbankname(@PathVariable("name") String name)
	{
		bank m2=bankservice.geteachbankname(name);
		if(m2!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(m2);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(m2);
	}
	
	}
	@GetMapping("/bank/count")
	public int getbankcount()
	{
		int count=bankservice.getbankcount();
		return count;
		
	
	}
	
	@GetMapping("/bank/countbyjpa")
	public long getcountbyjpa()
	{
		long count=bankservice.getcountbyjpa();
		return count;
	
	}
	
	@PutMapping("bank/{id}")
	public String updatebank(@RequestBody bank bank,@PathVariable("id") int bankid)
	{
		String message=bankservice.updatebank(bank,bankid);
		return message;
	}
	
	@DeleteMapping("bank/{id}")
	public String deletebank(@PathVariable("id") int id)
	{
		String message=bankservice.deletebank(id);
		return message;
	}
	
}
