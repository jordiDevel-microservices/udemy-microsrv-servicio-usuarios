package org.myself.udemy.springboot.app.usuarios.controller;

import java.util.List;

import org.myself.udemy.springboot.app.usuarios.entity.Usuario;
import org.myself.udemy.springboot.app.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> listar() {
		return this.usuarioService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<Usuario> detalle(@PathVariable Long id) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			return new ResponseEntity<>(usuarioDb, HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/buscar/login/{login}")
	public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login) {
		Usuario usuarioDb = this.usuarioService.findByLogin(login);
		
		if (usuarioDb != null) {
			return new ResponseEntity<>(usuarioDb, HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/buscar/email/{email}")
	public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String email) {
		Usuario usuarioDb = this.usuarioService.findByEmail(email);
		
		if (usuarioDb != null) {
			return new ResponseEntity<>(usuarioDb, HttpStatus.OK); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<Usuario> editar(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			usuarioDb.setNombre(usuario.getNombre());
			usuarioDb.setApellido(usuario.getApellido());
			
			return new ResponseEntity<>(this.usuarioService.save(usuarioDb), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/incLoginAttempts/{id}")
	public ResponseEntity<Usuario> incrementLoginAttempts(@PathVariable Long id) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			Integer loginAttempts = usuarioDb.getLoginAttempts() == null ? 0 : usuarioDb.getLoginAttempts();
			usuarioDb.setLoginAttempts(loginAttempts + 1);
			
			return new ResponseEntity<>(this.usuarioService.save(usuarioDb), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/resetLoginAttempts/{id}")
	public ResponseEntity<Usuario> resetLoginAttempts(@PathVariable Long id) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			usuarioDb.setLoginAttempts(0);
			
			return new ResponseEntity<>(this.usuarioService.save(usuarioDb), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/disable/{id}")
	public ResponseEntity<Usuario> disableUsuario(@PathVariable Long id) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			usuarioDb.setEnabled(false);
			
			return new ResponseEntity<>(this.usuarioService.save(usuarioDb), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/enable/{id}")
	public ResponseEntity<Usuario> enableUsuario(@PathVariable Long id) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			usuarioDb.setEnabled(true);
			
			return new ResponseEntity<>(this.usuarioService.save(usuarioDb), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		Usuario usuarioDb = this.usuarioService.findById(id);
		
		if (usuarioDb != null) {
			this.usuarioService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
