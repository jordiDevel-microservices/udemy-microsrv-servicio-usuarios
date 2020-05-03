package org.myself.udemy.springboot.app.usuarios.service;

import java.util.List;

import org.myself.udemy.springboot.app.usuarios.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario findByLogin(String login);
	
	public Usuario findByEmail(String email);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
	
}
