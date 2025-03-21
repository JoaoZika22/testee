package com.itb.lip2.weggie.controller;


import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itb.lip2.weggie.model.Empresa;
import com.itb.lip2.weggie.model.Funcionario;
import com.itb.lip2.weggie.service.EmpresaService;
import com.itb.lip2.weggie.service.FuncionarioService;

import java.net.URI;

@RestController
@RequestMapping("/weggie/api/v1/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final EmpresaService empresaService;
    public FuncionarioController(FuncionarioService funcionarioService, EmpresaService empresaService) {
        this.funcionarioService = funcionarioService;
        this.empresaService = empresaService;
    }

    @PostMapping("/salvar-empresa")
    public ResponseEntity<Empresa> salvarEmpresa(@RequestBody Empresa empresa){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/agendamentus/api/v1/users").toUriString());
        return ResponseEntity.created(uri).body(empresaService.save(empresa));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable(value="id") Long id) {
        try {
            return ResponseEntity.ok().body(funcionarioService.update(id, funcionario));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
