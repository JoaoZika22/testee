package com.itb.lip2.weggie.service;

import com.itb.lip2.weggie.model.Empresa;

public interface EmpresaService {

    Empresa update(Long id, Empresa empresa) throws Exception;
    Empresa save(Empresa empresa);
}
