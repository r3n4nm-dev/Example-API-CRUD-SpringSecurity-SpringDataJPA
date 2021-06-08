package com.renanmateus.authorizefuncionario.domain.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanmateus.authorizefuncionario.domain.model.Funcionario;
import com.renanmateus.authorizefuncionario.domain.repository.FuncionarioRepository;

@Service
public class CadastroFuncionario {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
		
	}
	
	public void deletar(long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		
		if(funcionario.isEmpty()) {
			throw new EntityNotFoundException("Funcionário não encontrado.");
			
		}
		
		funcionarioRepository.delete(funcionario.get());
	}
	
	
}
