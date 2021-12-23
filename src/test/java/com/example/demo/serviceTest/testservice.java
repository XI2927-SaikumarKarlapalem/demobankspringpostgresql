package com.example.demo.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.entity.bank;
import com.example.demo.repository.bankrepository;
import com.example.demo.service.bankservice;




@SpringBootTest
public class testservice {
	@Mock
	private bankrepository bankrepository;
	@InjectMocks
	private bankservice bankservice;
	@Test
	public void testgetallbanks()
	{
		List<bank> banklist=new ArrayList<>();
		banklist.add(new bank(1,"bank1","banklocation1"));
		banklist.add(new bank(2,"bank2","banklocation2"));
		banklist.add(new bank(3,"bank3","banklocation3"));
		
		when(bankrepository.findAll()).thenReturn(banklist);
		List<bank> actualbanklist=bankservice.getallbanks(0,0,"asc");
		assertEquals(banklist.size(),actualbanklist.size());
		
	}
	
	@Test
	public void testgeteachbank(){
		int id=1;
		bank b=new bank(id,"bank","banklocation");
		when(bankrepository.findById(id)).thenReturn(Optional.of(b));
		bank actualbank=bankservice.geteachbank(id);
		assertEquals(b.getName(),actualbank.getName());
		
	}
	@Test
    public void testaddbank()
    {
		bank b=new bank(1,"bank","bank1location");
		when(bankrepository.save(b)).thenReturn(b);
		String expmsg="bank added";
		String actualmsg=bankservice.addbank(b);
		assertEquals(expmsg,actualmsg);
    }
	
	
}