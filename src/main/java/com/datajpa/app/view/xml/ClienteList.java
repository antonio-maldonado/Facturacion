package com.datajpa.app.view.xml;

import java.util.List;

import com.datajpa.app.models.entity.Cliente;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="clientes")

public class ClienteList {
	@XmlElement(name="cliente")
	public List<Cliente> clientes;

	public ClienteList(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteList() {

	}

	public List<Cliente> getClientes() {
		return clientes;
	}
	
}
