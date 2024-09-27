package com.itb.lip2.weggie.service;

import java.util.List;

import com.itb.lip2.weggie.model.Carro;

public interface CarroService {

    List<Carro> findAll();
    Carro findbyId(Long id);
    Carro saveAgentamento(Carro carros);


}
