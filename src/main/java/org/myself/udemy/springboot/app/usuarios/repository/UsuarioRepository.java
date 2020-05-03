package org.myself.udemy.springboot.app.usuarios.repository;

import java.util.Optional;

import org.myself.udemy.springboot.app.usuarios.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	public Optional<Usuario> findByLogin(String login);
	
	public Optional<Usuario> findByEmail(String email);
	
}
