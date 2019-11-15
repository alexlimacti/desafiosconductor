package com.desafio.conductor.repository;

import com.desafio.conductor.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Contas, Long> {

    public Contas findByCartao(Long cartao);

}
