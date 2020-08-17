package com.bolsadeideas.springboot.backend.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.dao.IClienteDAO;
import com.bolsadeideas.springboot.backend.apirest.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.service.IClienteService;

@Service("clienteService")
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDAO clienteDao;
	
	@Override
	@Transactional(readOnly = true) //Se especifica de forma explicita
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true) //Se especifica de forma explicita
	public Cliente findById(long id) {
		return clienteDao.findById(id).orElse(null); // Si no existe devolverá null
	}

	@Override
	@Transactional // Se especifica que se pueden realizar todas operaciones
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional // Se especifica que se pueden realizar todas operaciones
	public void delete(long id) {
		clienteDao.deleteById(id);
	}
}
