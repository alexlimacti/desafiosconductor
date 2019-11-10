package com.desafio.conductor.service;

import com.desafio.conductor.model.Pessoas;
import com.desafio.conductor.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoas> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoas getOne(Long aLong) {
        return pessoaRepository.getOne(aLong);
    }

    public <S extends Pessoas> S save(S s) {
        return pessoaRepository.save(s);
    }

    public void delete(Pessoas pessoas) {
        pessoaRepository.delete(pessoas);
    }
}
