package com.Mapstodos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mapstodos.dto.FuncionarioDTO;
import com.Mapstodos.entities.Funcionario;
import com.Mapstodos.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

	
	
	 public List<Funcionario> getAllFuncionario () {
	        return funcionarioRepository.findAll();
	    }

	    public Funcionario getFuncionarioById(Long id) {
	        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
	        return funcionario.orElse(null);
	    }

	    public FuncionarioDTO salvar(FuncionarioDTO funcionarioDTO) {
	    	Funcionario Funcionario = new Funcionario ( funcionarioDTO.id(), funcionarioDTO.nome());
	    	Funcionario salvarFuncionario = funcionarioRepository.save(Funcionario);
		
			return new FuncionarioDTO (salvarFuncionario.getId(), salvarFuncionario.getNome() );
	    }

	    public FuncionarioDTO update(Long id, FuncionarioDTO FuncionarioDTO) {
	    	Funcionario existeFuncionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario nao encontrado"));
	    	existeFuncionario.setNome(FuncionarioDTO.nome());
	    	
	    	
	    	Funcionario updateFuncionario = funcionarioRepository.save(existeFuncionario);
	    	
	    	 return new FuncionarioDTO (updateFuncionario.getId(), updateFuncionario.getNome() );
	        }
	       
	    

	    public boolean delete(Long id) {
	        Optional<Funcionario> existingFuncionario = funcionarioRepository.findById(id);
	        if (existingFuncionario.isPresent()) {
	        	funcionarioRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	    
	    public List <Funcionario> buscarTodos(){
	    return funcionarioRepository.findAll();	
	    }
	    
	    public Funcionario buscaPorId (Long id) {
	    	Optional <Funcionario> Funcionario = funcionarioRepository.findById(id);
	    	return Funcionario.orElse(null);
	    }


}
