package com.datajpa.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datajpa.app.models.service.IClienteService;
import com.datajpa.app.view.xml.ClienteList;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(value="/listar")
	public ClienteList listar() {
		return new ClienteList(clienteService.findAll());
	}
}
