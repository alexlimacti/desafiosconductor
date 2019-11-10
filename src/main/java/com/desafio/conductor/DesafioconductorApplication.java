package com.desafio.conductor;

import com.desafio.conductor.model.Contas;
import com.desafio.conductor.model.Pessoas;
import com.desafio.conductor.model.TipoConta;
import com.desafio.conductor.model.Transacoes;
import com.desafio.conductor.repository.ContaRepository;
import com.desafio.conductor.repository.PessoaRepository;
import com.desafio.conductor.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DesafioconductorApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(DesafioconductorApplication.class, args);
    }

    public void run(String... args) throws Exception {
/*
        Pessoas p1 = new Pessoas();
        p1.setCpf("123456789");
        p1.setDataNascimento(new Date());
        p1.setNome("pessoa 1");

        Pessoas p2 = new Pessoas();
        p2.setCpf("12556789");
        p2.setDataNascimento(new Date());
        p2.setNome("pessoa 2");

        pessoaRepository.saveAll(Arrays.asList(p1,p2));

        Contas c1 = new Contas();
        c1.setCartao(123456789);
        c1.setDataCriacao(new Date());
        c1.setTipoConta(TipoConta.CORRENTE);
        c1.setFlagAtivo(true);
        c1.setLimiteSaqueDiario(new BigDecimal("1000"));
        c1.setSaldo(new BigDecimal("100000"));
        c1.setIdPessoa(p2);

        Contas c2 = new Contas();
        c2.setCartao(55668754);
        c2.setDataCriacao(new Date());
        c2.setTipoConta(TipoConta.CORRENTE);
        c2.setFlagAtivo(true);
        c2.setLimiteSaqueDiario(new BigDecimal("5000"));
        c2.setSaldo(new BigDecimal("150000"));
        c2.setIdPessoa(p1);

        contaRepository.saveAll(Arrays.asList(c1,c2));

        Transacoes t1 = new Transacoes();
        t1.setDataTransacao(new Date());
        t1.setHoraTransacao(new Date());
        t1.setIdConta(c2);
        BigDecimal valor = new BigDecimal("3000");
        t1.setValor(valor);

        Transacoes t2 = new Transacoes();
        t1.setDataTransacao(new Date());
        t1.setHoraTransacao(new Date());
        t1.setIdConta(c1);
        BigDecimal valor2 = new BigDecimal("85000");
        t1.setValor(valor2);

        transacaoRepository.saveAll(Arrays.asList(t1,t2));
*/
    }

}
