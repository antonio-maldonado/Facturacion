package com.datajpa.app.view.json;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.datajpa.app.models.entity.Cliente;
import com.datajpa.app.view.xml.ClienteList;

@Component("/listar.json")
public class ClienteListJsonView extends MappingJackson2JsonView{

	@Override
	protected Object filterModel(Map<String, Object> model) {
		
		model.remove("titulo");
		model.remove("page");
		
		Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");
		
		model.remove("clientes");
		
		//model.put("clienteList",new ClienteList( clientes.getContent()));
		model.put("clientes", clientes.getContent());
		
		return super.filterModel(model);
	}

	
	
}
