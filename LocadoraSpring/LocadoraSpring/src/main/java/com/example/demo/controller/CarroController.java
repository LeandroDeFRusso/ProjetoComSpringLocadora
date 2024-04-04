package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    CarroService carroService;

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listarCarros();
    }

    @PostMapping
    public Carro criarCarro(@Valid @RequestBody Carro carro) {
        return carroService.criarCarro(carro);
    }

    @PutMapping("/{idCarro}")
    public ResponseEntity<?> atualizarCarro(@PathVariable Long idCarro, @RequestBody Carro carro) {
        //return carroService.atualizar(idCarro, carro);
        if(carroService.atualizarCarro(idCarro, carro) == null) {

            String mensagem = "O idCarro informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
           //return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{idCarro}")
    public ResponseEntity<?> deletarCarro(@PathVariable Long idCarro) {
        if(carroService.deletarCarro(idCarro)) {
            String mensagem = "A deleção do idCarro: " + idCarro + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O idCarro informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-carros")
    public int qtdCarros() {
        return carroService.qtdCarros();
    }

    @GetMapping("/modelo/{modelo}")
    public List<Carro> buscarPorModelo(@PathVariable String modelo) {
        return carroService.buscarCarrosPorModelo(modelo);
    }

    @GetMapping("/marca/{marca}")
    public List<Carro> buscarPorMarca(@PathVariable String marca) {
        return carroService.buscarCarrosPorMarca(marca);
    }
}
