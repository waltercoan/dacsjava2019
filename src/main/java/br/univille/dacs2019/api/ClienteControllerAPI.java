package br.univille.dacs2019.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.dacs2019.model.Cliente;
import br.univille.dacs2019.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControllerAPI {
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			lista = service.getAll();
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente){
		service.save(cliente);
		return ResponseEntity.ok().build();
	}
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, 
									@RequestBody Cliente cliente){
		Cliente clienteAtual = service.findById(id);
		if(clienteAtual != null) {
			clienteAtual.setNome(cliente.getNome());
			clienteAtual.setEndereco(cliente.getEndereco());
			clienteAtual.setDataNascimento(cliente.getDataNascimento());
			service.save(clienteAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Cliente clienteAtual = service.findById(id);
		if(clienteAtual != null) {
			service.remove(clienteAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	
	
	
	
	
	
}
