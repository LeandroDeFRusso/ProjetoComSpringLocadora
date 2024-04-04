package com.example.demo.service;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;


    public List<Pessoa> listarPessoas() { return pessoaRepository.findAll();}


    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    public Pessoa atualizarPessoa(Pessoa pessoa, Long idPessoa) {
            if(pessoaRepository.existsById(idPessoa)) {
                pessoa.setIdPessoa(idPessoa);
                return pessoaRepository.save(pessoa);
            } else {
                return null;
            }
        }


        public boolean deletarPessoa(Long idPessoa) {
            if (pessoaRepository.existsById(idPessoa)) {
                pessoaRepository.deleteById(idPessoa);
                return true;
            } else {
                return false;
            }
        }
    public int qtdPessoas () {
        return pessoaRepository.findAll().size();
    }

    public List<Pessoa> buscarPessoasPorNome(String nome) {
        return pessoaRepository.findByNome(nome);
    }

}


