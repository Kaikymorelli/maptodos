package com.Mapstodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mapstodos.dto.FuncionarioDTO;
import com.Mapstodos.entities.Funcionario;
import com.Mapstodos.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@PostMapping

	public ResponseEntity<FuncionarioDTO> update(@RequestBody @Valid FuncionarioDTO funcionarioDTO){

		FuncionarioDTO salvarFuncionario = funcionarioService.salvar(funcionarioDTO);

	return ResponseEntity.status(HttpStatus.CREATED).body(salvarFuncionario);

	}


	@PutMapping("/{id}")

	public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @RequestBody @Valid FuncionarioDTO funcionarioDTO){

		FuncionarioDTO updateFuncionarioDTO = funcionarioService.update(id, funcionarioDTO);

	if(updateFuncionarioDTO != null) {

	return ResponseEntity.ok(updateFuncionarioDTO);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@DeleteMapping ("/{id}")

	public ResponseEntity<Funcionario> delete (@PathVariable Long id) {

	boolean delete = funcionarioService.delete(id);

	if (delete) {

	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@GetMapping("/{id}")

	public ResponseEntity<Funcionario> buscarPorId (@PathVariable Long id){

		Funcionario funcionario = funcionarioService.buscaPorId(id);

	if(funcionario != null) {

	return ResponseEntity.ok(funcionario);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}
	@GetMapping

	public ResponseEntity<List<Funcionario>> buscaTodos() {

	List <Funcionario> funcionario = funcionarioService.buscarTodos();

	return ResponseEntity.ok(funcionario);

	}


}
