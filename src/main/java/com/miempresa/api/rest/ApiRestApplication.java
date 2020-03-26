package com.miempresa.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ApiRestApplication implements  CommandLineRunner{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------------Leyendo productos de BD--------------");
		System.out.println("name");
		jdbcTemplate.query("SELECT * FROM PRODUCTO", (rs)-> {
			System.out.println(rs.getString("name"));
		});

	}

}
