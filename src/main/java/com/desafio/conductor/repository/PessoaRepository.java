package com.desafio.conductor.repository;

import com.desafio.conductor.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoas,Long> {
}
