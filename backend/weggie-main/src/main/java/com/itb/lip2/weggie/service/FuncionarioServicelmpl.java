package com.itb.lip2.weggie.service;

import org.springframework.stereotype.Service;

import com.itb.lip2.weggie.model.Funcionario;
import com.itb.lip2.weggie.repository.FuncionarioRepository;

@Service
public class FuncionarioServicelmpl implements FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;

    FuncionarioServicelmpl(FuncionarioRepository funcionarioRepository) {

        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario update(Long id, Funcionario funcionario) throws Exception {
        return funcionarioRepository.findById(id).map(fu ->{
            fu.setNome(funcionario.getNome());
            fu.setEmail(funcionario.getEmail());
            return funcionarioRepository.save(fu);
        }).orElseThrow(()->new Exception("Funcionário não encontrado!"));
    }
}
