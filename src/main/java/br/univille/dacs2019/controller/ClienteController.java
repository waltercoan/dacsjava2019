package br.univille.dacs2019.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dacs2019.model.Cliente;
import br.univille.dacs2019.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping()
	public ModelAndView index() {
		return new ModelAndView("cliente/index","clientes",service.getAll());
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Cliente cliente) {
		return new ModelAndView("cliente/form");
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Cliente cliente)
	{
		service.save(cliente);
		return new ModelAndView("redirect:/cliente");
	}
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Cliente cliente) {
		return new ModelAndView("cliente/form","cliente",cliente);
	}
	
	
}








