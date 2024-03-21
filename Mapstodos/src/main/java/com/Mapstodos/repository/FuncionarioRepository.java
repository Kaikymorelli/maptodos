package com.Mapstodos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mapstodos.entities.Funcionario;

public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long>{

}
