package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entity.Patient;



@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// test de la couche dao
		patientRepository.save(new Patient(null,"hassan",new Date(),false));
		patientRepository.save(new Patient(null,"momo",new Date(),false));
		patientRepository.save(new Patient(null,"pseudo",new Date(),true));
		
		patientRepository.findAll().forEach(p -> {
			System.out.println(p.getNom());
		});
		
		/*
		 * on a pas besoin de définir la source dans le fichier application.propreties 
		 * car on utilise une base de données H2 qui stocke les données en mémoire
		 */
		

		
	}

}
