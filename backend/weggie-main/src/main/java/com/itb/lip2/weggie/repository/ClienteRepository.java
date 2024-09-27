package com.itb.lip2.weggie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.lip2.weggie.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}