package com.bolsadeideas.springboot.backend.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{

}
