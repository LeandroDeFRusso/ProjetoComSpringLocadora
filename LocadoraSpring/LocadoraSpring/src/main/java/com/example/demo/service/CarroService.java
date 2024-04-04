package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

    public Carro criarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizarCarro(Long idCarro, Carro carro) {
        //verificar se o idCarro é valido
        if(carroRepository.existsById(idCarro)) {
            //atualizar o objeto na base
            carro.setIdCarro(idCarro);
            return carroRepository.save(carro);
        }
            return null;
            // não realiza nenhuma alteração

    }

    public boolean deletarCarro(Long idCarro) {
        if(carroRepository.existsById(idCarro)) {
            carroRepository.deleteById(idCarro);
            return true;
        } else {
            return false;
        }
    }

    public int qtdCarros () {
        return carroRepository.findAll().size();
    }

    public List<Carro> buscarCarrosPorMarca(String marca) {
        return carroRepository.findByMarca(marca);
    }

    public List<Carro> buscarCarrosPorModelo(String modelo) {
        return carroRepository.findByModelo(modelo);
    }
}
