package com.itb.lip2.weggie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itb.lip2.weggie.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long > {
}
