package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    private String nome;
    private int idade;

    @OneToOne(mappedBy = "pessoa")
    private Carro carro;

    @NotNull(message = "Cpf não pode ser nulo.")
    @Column(nullable = false)
    @Size(min = 11, max = 11)
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, Carro carro, Long idPessoa, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.carro = carro;
        this.idPessoa = idPessoa;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
