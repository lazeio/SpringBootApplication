package com.example.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// lombok il intervient au moment de la compilation
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom; 
	private Date datedenaissance;
	private boolean malade;
	

}
