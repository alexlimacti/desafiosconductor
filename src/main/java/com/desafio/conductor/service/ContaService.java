package com.desafio.conductor.service;

import com.desafio.conductor.dto.ContaPessoaDTO;
import com.desafio.conductor.dto.ContaSaldoDTO;
import com.desafio.conductor.dto.SaqueDTO;
import com.desafio.conductor.model.Contas;
import com.desafio.conductor.model.Pessoas;
import com.desafio.conductor.model.TipoConta;
import com.desafio.conductor.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<Contas> findAll() {
        return contaRepository.findAll();
    }

    public Contas getOne(Long aLong) {
        return contaRepository.getOne(aLong);
    }

    public <S extends Contas> S save(S s) {
        return contaRepository.save(s);
    }

    public long count() {
        return contaRepository.count();
    }

    public void delete(Contas contas) {
        contaRepository.delete(contas);
    }

    public Contas findByCartao(Long cartao) {
        return contaRepository.findByCartao(cartao);
    }

    public Long geraNumeroCartao(){
        boolean existe = true;
        Long numeroCartao = 0L;
        while (existe) {
            numeroCartao = (long) (1000000000000000l + Math.random() * 8999999999999999l);
            existe  = (findByCartao(numeroCartao) == null) ? false : true;
        }
        return numeroCartao;
    }

    public Contas criarConta(ContaPessoaDTO contaPessoaDTO) {
        Pessoas pessoa = new Pessoas();
        pessoa.setCpf(contaPessoaDTO.getCpf());
        pessoa.setNome(contaPessoaDTO.getNome());
        pessoa.setDataNascimento(contaPessoaDTO.getDataNascimento());

        Contas conta = new Contas();
        conta.setFlagAtivo(true);
        conta.setSaldo(contaPessoaDTO.getSaldo());
        conta.setLimiteSaqueDiario(contaPessoaDTO.getLimiteSaqueDiario());
        conta.setCartao(geraNumeroCartao());
        conta.setTipoConta(TipoConta.toEnum(contaPessoaDTO.getTipoConta()));
        conta.setDataCriacao(new Date());
        conta.setIdPessoa(pessoaService.save(pessoa));
        return contaRepository.save(conta);
    }

    public ContaSaldoDTO getSaldo(Long idConta){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat pf = NumberFormat.getCurrencyInstance();
        Contas conta = getOne(idConta);
        ContaSaldoDTO csd = new ContaSaldoDTO();
        csd.setConta(idConta.toString());
        csd.setData(sdf.format(new Date()));
        csd.setSaldo(pf.format(conta.getSaldo().doubleValue()));
        return csd;
    }

    public void bloqueio(Long idConta){
        Contas conta = contaRepository.getOne(idConta);
        conta.setFlagAtivo(false);
        contaRepository.save(conta);
    }

    public void desbloqueio(Long idConta){
        Contas conta = contaRepository.getOne(idConta);
        conta.setFlagAtivo(true);
        contaRepository.save(conta);
    }

}
