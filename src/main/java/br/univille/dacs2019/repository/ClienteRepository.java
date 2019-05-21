package br.univille.dacs2019.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.univille.dacs2019.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	Cliente findByNome(String nome);
}
