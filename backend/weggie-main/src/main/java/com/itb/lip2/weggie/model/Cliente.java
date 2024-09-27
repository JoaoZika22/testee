package com.itb.lip2.weggie.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Cliente")
public class Cliente extends Usuario {



    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Carro> carros = new ArrayList<Carro>();


    public Cliente() {


    }
    public Cliente(Long id, String nome, String email, String senha, String tipoUsuario, Collection<Papel> papeis) {
        super(id, nome, email, senha, tipoUsuario, papeis);  // Acesso ao construtor da classe pai
    }



    public List<Carro> getAgendamentos() {
        return carros;
    }

    public void setAgendamentos(List<Carro> carros) {
        this.carros = carros;
    }


}

