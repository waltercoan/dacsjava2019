package br.univille.dacs2019;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.dacs2019.model.Usuario;
import br.univille.dacs2019.repository.UsuarioRepository;

@Component
public class StartupEventListenerBean {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(usuarioRepository.findByUsername("user") == null) {
			Usuario user = new Usuario();
			user.setUsername("user");
			user.setPassword("user");
			user.setRole("ROLE_USER");
			usuarioRepository.save(user);
		}

	}
}