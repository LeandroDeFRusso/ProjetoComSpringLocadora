package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarPessoa() {
        return pessoaService.listarPessoas();
    }

    @PostMapping
    public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<?> atualizarPessoa(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
        if(pessoaService.atualizarPessoa(pessoa, idPessoa) == null) {

            String mensagem = "O Id da Pessoa informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<?> deletar(@PathVariable Long idPessoa) {
        if(pessoaService.deletarPessoa(idPessoa)) {
            String mensagem = "A deleção do Id da Pessoa: " + idPessoa + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O Id da Pessoa informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd-pessoas")
    public int qtdPessoas() {
        return pessoaService.qtdPessoas();
    }

    @GetMapping("/nome/{nome}")
    public List<Pessoa> buscarPorNome(@PathVariable String nome) {
        return pessoaService.buscarPessoasPorNome(nome);
    }
}