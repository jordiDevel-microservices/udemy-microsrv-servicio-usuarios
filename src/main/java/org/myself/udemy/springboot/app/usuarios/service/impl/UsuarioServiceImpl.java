package org.myself.udemy.springboot.app.usuarios.service.impl;

import java.util.List;

import org.myself.udemy.springboot.app.usuarios.entity.Usuario;
import org.myself.udemy.springboot.app.usuarios.repository.UsuarioRepository;
import org.myself.udemy.springboot.app.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>)this.usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return this.usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario findByLogin(String login) {
		return this.usuarioRepository.findByLogin(login).orElse(null);
	}

	@Override
	public Usuario findByEmail(String email) {
		return this.usuarioRepository.findByEmail(email).orElse(null);
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		this.usuarioRepository.deleteById(id);
	}
	
}
