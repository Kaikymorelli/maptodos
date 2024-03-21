package com.Mapstodos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mapstodos.dto.DepartamentoDTO;
import com.Mapstodos.entities.Departamento;
import com.Mapstodos.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

	
	
	 public List<Departamento> getAllDepartamento () {
	        return departamentoRepository.findAll();
	    }

	    public Departamento getDepartamentoById(Long id) {
	        Optional<Departamento> departamento = departamentoRepository.findById(id);
	        return departamento.orElse(null);
	    }

	    public DepartamentoDTO salvar(DepartamentoDTO departamentoDTO) {
	    	Departamento departamento = new Departamento ( departamentoDTO.id(), departamentoDTO.nome());
	    	Departamento salvarDepartamento = departamentoRepository.save(departamento);
		
			return new DepartamentoDTO (salvarDepartamento.getId(), salvarDepartamento.getNome() );
	    }

	    public DepartamentoDTO update(Long id, DepartamentoDTO DepartamentoDTO) {
	    	Departamento existeDepartamento = departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento nao encontrado"));
	    	existeDepartamento.setNome(DepartamentoDTO.nome());
	    	
	    	
	    	Departamento updateDepartamento = departamentoRepository.save(existeDepartamento);
	    	
	    	 return new DepartamentoDTO (updateDepartamento.getId(), updateDepartamento.getNome() );
	        }
	       
	    

	    public boolean delete(Long id) {
	        Optional<Departamento> existingDepartamento = departamentoRepository.findById(id);
	        if (existingDepartamento.isPresent()) {
	        	departamentoRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	    
	    public List <Departamento> buscarTodos(){
	    return departamentoRepository.findAll();	
	    }
	    
	    public Departamento buscaPorId (Long id) {
	    	Optional <Departamento> pet = departamentoRepository.findById(id);
	    	return pet.orElse(null);
	    }

}
