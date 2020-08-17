package com.bolsadeideas.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.service.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	
	/* Método para traer todos los registros
	 * 
	 * */
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	/* Método para buscar un registro en especifico
	 * 
	 * @PathVariable long id: Se indica que se recibe como parametro la variable id en la url
	 * 
	 * */
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable long id) {
		return clienteService.findById(id);
	}
	
	/*	Metodo para crear un registro
	 *  
	 *  @ResponseStatus(HttpStatus.CREATED): Devolvera el codigo 201, de creacion
	 *  @RequestBody Cliente cliente: Spring recibirá el json y lo mapeará como un objeto cliente
	 * */
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED) 
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	/* Método para actualizar un registro
	 * 
	 * 
	 * */
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable long id) {
		/**/
		Cliente clienteActual = clienteService.findById(id);
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		/**/
		return clienteService.save(clienteActual);
	}
	
	/* Método para eliminar un registro
	 * 
	 * */
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		clienteService.delete(id);
	}
	
	
}
