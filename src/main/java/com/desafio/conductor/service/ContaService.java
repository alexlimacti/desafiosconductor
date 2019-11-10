package com.desafio.conductor.service;

import com.desafio.conductor.dto.ContaSaldoDTO;
import com.desafio.conductor.model.Contas;
import com.desafio.conductor.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

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

}
