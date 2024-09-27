package com.itb.lip2.weggie.service;

import com.itb.lip2.weggie.model.Cliente;

public interface ClienteService {

    Cliente update(Long id, Cliente cliente) throws Exception;
}
