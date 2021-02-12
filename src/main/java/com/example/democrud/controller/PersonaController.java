package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceApi;

@Controller
public class PersonaController {
	
	@Autowired
	private PersonaServiceApi personaServiceApi;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", personaServiceApi.getAll());
		return "index";
	}
	
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("persona", personaServiceApi.get(id));
		}else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		personaServiceApi.save(persona);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		personaServiceApi.delete(id);
		
		return "redirect:/";
	}
}