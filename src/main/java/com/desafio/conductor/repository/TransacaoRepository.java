package com.desafio.conductor.repository;

import com.desafio.conductor.model.Contas;
import com.desafio.conductor.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacoes, Long> {

    public List<Transacoes> findByIdConta(Contas idConta);

    @Query(value = "from Transacoes t where t.idConta = :idconta and t.dataTransacao between :dataini and :datafim")
    public List<Transacoes> findByIdContaAndDataTransacao(@Param("idconta") Contas idconta, @Param("dataini")Date dataIni, @Param("datafim")Date datafim);

    //@Query(value="from Transacoes t where date_format(t.dataTransacao, '%Y-%m-%d')= :datatransacao")
    public List<Transacoes> findByDataTransacao(Date dataTransacao);

}
