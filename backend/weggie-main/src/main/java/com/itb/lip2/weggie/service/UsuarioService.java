package com.itb.lip2.weggie.service;

import java.util.List;
import java.util.Optional;

import com.itb.lip2.weggie.model.Cliente;
import com.itb.lip2.weggie.model.Funcionario;
import com.itb.lip2.weggie.model.Papel;
import com.itb.lip2.weggie.model.Usuario;

public interface UsuarioService {

	Usuario save(Usuario usuario);
	Usuario saveFuncionario(Funcionario funcionario);
	Usuario saveCliente(Cliente cliente);
	List<Usuario> findAll();
	Optional<Usuario> findById(Long id);
	Usuario update(Long id, Usuario usuario) throws Exception;
	Papel savePapel(Papel papel);
	void addPapelToUsuario(Usuario usuario, String nomePapel);

	Usuario findByUsername(String username);



}