package org.myself.udemy.springboot.app.usuarios.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 6826891920031295561L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String login;
	
	@Column(length = 60)
	private String password;
	private Boolean enabled;
	private String nombre;
	private String apellido;
	
	@Column(unique = true, length = 100)
	private String email;
	
	@Column(columnDefinition = "integer default 0")
	private Integer loginAttempts;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "usuarios_roles", 
		joinColumns = @JoinColumn(name = "usuario_id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id"),
		uniqueConstraints = @UniqueConstraint(columnNames = { "usuario_id", "role_id" })
	)
	private List<Role> roles;
	
}
