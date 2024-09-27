package com.itb.lip2.weggie.service;

import com.itb.lip2.weggie.model.Funcionario;

public interface FuncionarioService {

    Funcionario update(Long id, Funcionario funcionario) throws Exception;
}
