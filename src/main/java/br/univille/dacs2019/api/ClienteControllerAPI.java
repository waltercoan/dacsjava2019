package br.univille.dacs2019.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Cliente> lista = service.getAll();
		return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
	}

}
