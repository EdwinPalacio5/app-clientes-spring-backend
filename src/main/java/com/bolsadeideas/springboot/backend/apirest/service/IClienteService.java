package com.bolsadeideas.springboot.backend.apirest.service;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.entity.Cliente;

public interface IClienteService {
	
	public abstract List<Cliente> findAll();
	
	public abstract Cliente findById(long id);
	
	public abstract Cliente save(Cliente cliente);
	
	public abstract void delete(long id);
}
