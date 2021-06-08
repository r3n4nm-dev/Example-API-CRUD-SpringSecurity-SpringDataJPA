package com.renanmateus.authorizefuncionario.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "funcionario")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 255)
	private String nomeCompleto;
	@Column(nullable = false, length = 2)
	private int idade;
	@Column(nullable = false, length = 255)
	private String funcao;
	
}
