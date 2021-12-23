package com.example.demo.test;

import static org.junit.Assert.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mathop.mathop;

@SpringBootTest
public class mathopTest {
	
	
	public void addtest(int a,int b)
	{
       mathop mathop=new mathop();
       int result=mathop.add(0,0);
       assertEquals(0,result);
       
       result=mathop.add(6,0);
       assertEquals(6,result);
       
       result=mathop.add(90,90);
       assertEquals(180,result);

       
	}
      
	
	public void multest(int a,int b)
	{
       mathop mathop=new mathop();
       int result=mathop.mul(0,0);
       assertEquals(0,result);
       
       result=mathop.add(6,0);
       assertEquals(0,result);
       
       result=mathop.add(90,90);
       assertEquals(8100,result);

       
	}
}
