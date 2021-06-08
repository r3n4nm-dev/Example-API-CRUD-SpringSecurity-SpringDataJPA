package com.renanmateus.authorizefuncionario.api.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.renanmateus.authorizefuncionario.domain.model.Funcionario;
import com.renanmateus.authorizefuncionario.domain.repository.FuncionarioRepository;
import com.renanmateus.authorizefuncionario.domain.service.CadastroFuncionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CadastroFuncionario cadastroFuncionario;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado.");

		}
		return ResponseEntity.ok(funcionario);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Funcionario funcionario) {
		funcionario = cadastroFuncionario.salvar(funcionario);
		return ResponseEntity.ok(funcionario);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody Funcionario funcionario) {
		Optional<Funcionario> funcionarioAtual = funcionarioRepository.findById(id);
		if (funcionarioAtual.isEmpty()) {
			return ResponseEntity.badRequest().body("Funcionário não encontrado.");
		}
		BeanUtils.copyProperties(funcionario, funcionarioAtual.get(), "id");
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionarioAtual.get());
		return ResponseEntity.ok(funcionarioSalvo);
		
}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable long id) {
		try {
			cadastroFuncionario.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
