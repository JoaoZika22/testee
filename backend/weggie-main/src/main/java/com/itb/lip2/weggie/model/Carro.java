package com.itb.lip2.weggie.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   protected Long id;
    protected String km;
    protected String ano;
    protected String modelo;
    protected String nomeCarro;
    protected String marca;
    protected String cor;
    protected String placa;
    protected String tipoCombustivel;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;

    public Carro() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKm() {
        return km;
    }
    public void setKm(String km) {
        this.km = km;
    }
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNomeCarro() {
        return nomeCarro;
    }

    public void setNomeCarro(String nome) {
        this.nomeCarro = nomeCarro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro that = (Carro) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
