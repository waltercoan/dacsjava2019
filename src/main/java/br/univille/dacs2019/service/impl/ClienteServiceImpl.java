package br.univille.dacs2019.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dacs2019.model.Cliente;
import br.univille.dacs2019.repository.ClienteRepository;
import br.univille.dacs2019.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

}
