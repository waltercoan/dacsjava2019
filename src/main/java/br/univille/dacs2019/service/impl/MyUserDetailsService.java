package br.univille.dacs2019.service.impl;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.univille.dacs2019.model.Usuario;
import br.univille.dacs2019.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository usuarioRepository;
 
    @Override
    public User loadUserByUsername(String username) {
        Usuario user = usuarioRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<SimpleGrantedAuthority> listGrants = new ArrayList<>();
        listGrants.add(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getUsername(),user.getPassword(),listGrants);
    }
}