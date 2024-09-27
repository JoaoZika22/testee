package com.itb.lip2.weggie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.itb.lip2.weggie.model.Cliente;
import com.itb.lip2.weggie.service.CarroService;
import com.itb.lip2.weggie.service.ClienteService;

@RestController
@RequestMapping("/weggie/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    private final CarroService carroService;
    ClienteController(ClienteService clienteService, CarroService agendamentoService) {
        this.clienteService = clienteService;
        this.carroService = agendamentoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@RequestBody Cliente cliente, @PathVariable(value="id") Long id) {
        try {
            return ResponseEntity.ok().body(clienteService.update(id, cliente));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    /*@PostMapping("/agendamento")
    public R
*/


}
