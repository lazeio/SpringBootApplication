package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PatientRepository;
import com.example.demo.entity.Patient;

@Controller
public class PatientController {
	
	@Autowired 
	private PatientRepository patientRepository;
	
	
	/*
	 * test une méthode qui permet de retourner une vue
	 * on mettre les vues basées sur thymleaf dans le dossier template 
	 */
	@GetMapping(path= "/")
	public String index(){
		
		return "index";
	}
	
	@GetMapping(path= "/listpatient")
	public String list(Model m,@RequestParam(name="page",defaultValue="0") int page, 
			@RequestParam(name="size",defaultValue="1")  int size,
			@RequestParam(name="keyword",defaultValue="")  String  mc){
		//List<Patient> patients = patientRepository.findAll();
		//Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
		Page<Patient> pagePatients = patientRepository.findByNomContains(mc, PageRequest.of(page, size));
		m.addAttribute("listpatient",pagePatients.getContent());
		m.addAttribute("pages", new int [pagePatients.getTotalPages()]);
		m.addAttribute("currentpage", pagePatients.getNumber());
		m.addAttribute("keyword", mc);
		return "listpatient";
	}
	
	
	@GetMapping(path= "/delete")
	public String delete(@RequestParam(name="id")Long id,String keyword,int page){
		patientRepository.deleteById(id);
		return "redirect:/listpatient?page="+ page +"&keyword="+keyword;
	}
	
	@GetMapping(path= "/deletev2")
	public String delete2(@RequestParam(name="id")Long id,String keyword,int page, int size,Model M){
		patientRepository.deleteById(id);
		return list(M, page,size,keyword);
	}

}