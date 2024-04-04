package com.example.demo.service;

import com.example.demo.model.Pessoa;

import java.util.List;

public interface PessoaServiceInt<T extends Pessoa> {
    List<T> listar();
    T criar(T t);
    T atualizar(T t, Long idPessoa);
    boolean deletar(Long idPessoa);

}