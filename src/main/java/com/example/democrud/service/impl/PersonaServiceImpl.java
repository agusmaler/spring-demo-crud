package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.PersonaDaoApi;
import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceApi;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceApi {

	@Autowired
	private PersonaDaoApi personaDaoApi;
	
	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaDaoApi;
	}

}
