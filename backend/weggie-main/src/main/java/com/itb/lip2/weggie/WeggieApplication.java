package com.itb.lip2.weggie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.itb.lip2.weggie.model.Papel;
import com.itb.lip2.weggie.repository.PapelRepository;
import com.itb.lip2.weggie.service.UsuarioService;

@SpringBootApplication
public class WeggieApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeggieApplication.class, args);

	}

	@Bean
	CommandLineRunner run(UsuarioService usuarioService, PapelRepository papelRepository){
		return args -> {
			//usuarioService.save(new Professor(null,"Rogerio","Caetano Santos", "nilcc@gmail.com", "1234", new ArrayList<>()));
			if(papelRepository.findAll().size() == 0) {
				usuarioService.savePapel(new Papel(null, "ROLE_FUNCIONARIO"));
				usuarioService.savePapel(new Papel(null, "ROLE_CLIENTE"));
			}else {
				System.out.println("Papeis já criados no banco de dados!");
			}
		};

}
}
