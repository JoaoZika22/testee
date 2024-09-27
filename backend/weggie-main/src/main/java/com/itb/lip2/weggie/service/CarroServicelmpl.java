package com.itb.lip2.weggie.service;

import com.itb.lip2.weggie.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itb.lip2.weggie.repository.CarroRepository;

import java.util.List;

@Service
public class CarroServicelmpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    public Carro findbyId(Long id) {
        return carroRepository.findById(id).get();
    }

    @Override
    public Carro saveAgentamento(Carro carros) {
        return carroRepository.save(carros);
    }

}
