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

import com.Mapstodos.dto.DepartamentoDTO;
import com.Mapstodos.entities.Departamento;
import com.Mapstodos.service.DepartamentoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}
	@PostMapping

	public ResponseEntity<DepartamentoDTO> update(@RequestBody @Valid DepartamentoDTO departamentoDTO){

		DepartamentoDTO salvarDepartamento = departamentoService.salvar(departamentoDTO);

	return ResponseEntity.status(HttpStatus.CREATED).body(salvarDepartamento);

	}


	@PutMapping("/{id}")

	public ResponseEntity<DepartamentoDTO> update(@PathVariable Long id, @RequestBody @Valid DepartamentoDTO departamentoDTO){

		DepartamentoDTO updateDepartamentoDTO = departamentoService.update(id, departamentoDTO);

	if(updateDepartamentoDTO != null) {

	return ResponseEntity.ok(updateDepartamentoDTO);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@DeleteMapping ("/{id}")

	public ResponseEntity<Departamento> delete (@PathVariable Long id) {

	boolean delete = departamentoService.delete(id);

	if (delete) {

	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}

	@GetMapping("/{id}")

	public ResponseEntity<Departamento> buscarPorId (@PathVariable Long id){

		Departamento departamento = departamentoService.buscaPorId(id);

	if(departamento != null) {

	return ResponseEntity.ok(departamento);

	}

	else {

	return ResponseEntity.notFound().build();

	}

	}
	@GetMapping

	public ResponseEntity<List<Departamento>> buscaTodos() {

	List <Departamento> departamento = departamentoService.buscarTodos();

	return ResponseEntity.ok(departamento);

	}

}
