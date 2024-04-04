package com.example.demo.service;

import com.example.demo.model.Veiculo;
import java.util.List;

public interface VeiculoServiceInt<X extends Veiculo> {
    List<X> listar();
    X salvar(X veiculo);
    X atualizar(X veiculo, Long id);
    boolean deletar(Long id);
}
