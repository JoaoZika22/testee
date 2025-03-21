package com.itb.lip2.weggie.service;

import org.springframework.stereotype.Service;

import com.itb.lip2.weggie.model.Cliente;
import com.itb.lip2.weggie.repository.ClienteRepository;

@Service
public class ClienteServicelmpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    ClienteServicelmpl(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente update(Long id, Cliente cliente) throws Exception {
        return clienteRepository.findById(id).map(cli ->{
            cli.setNome(cliente.getNome());
            cli.setEmail(cliente.getEmail());
            return clienteRepository.save(cli);
        }).orElseThrow(()->new Exception("Cliente não encontrado!"));
    }
}
