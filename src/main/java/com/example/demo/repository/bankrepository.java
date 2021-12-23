package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.bank;

public interface bankrepository extends JpaRepository<bank,Integer> {



	Optional<bank> findByname(String name);

	@Query(value="select count(*) from bank",nativeQuery=true)
	int getbankcount();





	
}
