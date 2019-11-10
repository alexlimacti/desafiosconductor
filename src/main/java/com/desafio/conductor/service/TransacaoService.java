package com.desafio.conductor.service;

import com.desafio.conductor.dto.DepositoDTO;
import com.desafio.conductor.dto.SaqueDTO;
import com.desafio.conductor.dto.TransacoesCartaoDTO;
import com.desafio.conductor.dto.TransacoesDTO;
import com.desafio.conductor.layout.CartaoLayout;
import com.desafio.conductor.model.Contas;
import com.desafio.conductor.model.Transacoes;
import com.desafio.conductor.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaService contaService;

    public List<Transacoes> findByIdConta(Contas idConta) {
        return transacaoRepository.findByIdConta(idConta);
    }

    public List<Transacoes> findAll() {
        return transacaoRepository.findAll();
    }

    public Transacoes getOne(Long aLong) {
        return transacaoRepository.getOne(aLong);
    }

    public void save(Transacoes entity){
    }

    public long count() {
        return transacaoRepository.count();
    }

    public void delete(Transacoes transacoes) {
        transacaoRepository.delete(transacoes);
    }

    public List<Transacoes> findByIdContaAndDataTransacao(Contas idconta, Date dataIni, Date datafim) {
        return transacaoRepository.findByIdContaAndDataTransacao(idconta, dataIni, datafim);
    }

    public List<Transacoes> findByDataTransacao(Date dataTransacao) {
        return transacaoRepository.findByDataTransacao(dataTransacao);
    }

    public File getLayout(Date dataLayout) throws IOException {
        String conteudo = "";
        List<Transacoes> listTransacoes = findByDataTransacao(dataLayout);
        for(Transacoes t:listTransacoes){
            if(t.getCartao() != null)
                conteudo = conteudo + getCartaoLayout(t);
        }
        File arquivo = new File("cartaolayout.txt");
        FileWriter f = new FileWriter(arquivo, false);
        f.write(conteudo);
        f.close();
        arquivo.createNewFile();
        return arquivo;
    }

    public String getCartaoLayout(Transacoes transacao){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        CartaoLayout cartaoLayout = new CartaoLayout();
        cartaoLayout.inicialize();
        cartaoLayout.getCartao().setValor(transacao.getCartao().toString());
        cartaoLayout.getDataTransacao().setValor(sdf.format(transacao.getDataTransacao()).toString());
        cartaoLayout.getValor().setValor(transacao.getValor().toString().replace(".",""));
        return cartaoLayout.getLinha() + System.getProperty("line.separator");
    }

    public List<TransacoesDTO> getExtrato(Long idConta, Date dataini, Date datafim){
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat horaFormat = new SimpleDateFormat("hh:mm:ss");
        NumberFormat pf = NumberFormat.getCurrencyInstance();
        Contas conta = contaService.getOne(idConta);
        List<Transacoes> lst = transacaoRepository.findByIdContaAndDataTransacao(conta, dataini, datafim);
        List<TransacoesDTO> lstDTO = new ArrayList<TransacoesDTO>();
        for(Transacoes t: lst){
            TransacoesDTO td = new TransacoesDTO();
            td.setValor(pf.format(t.getValor().doubleValue()));
            td.setDataTransacao(dataFormat.format(t.getDataTransacao()));
            td.setHoraTransacao(horaFormat.format(t.getHoraTransacao()));
            lstDTO.add(td);
        }
        return lstDTO;
    }

    public void deposito(DepositoDTO depositoDTO){
        Contas conta = contaService.getOne(depositoDTO.getIdconta());
        conta.setSaldo(conta.getSaldo().add(depositoDTO.getValor()));
        contaService.save(conta);
        Transacoes transacao = new Transacoes();
        transacao.setValor(depositoDTO.getValor());
        transacao.setDataTransacao(depositoDTO.getData());
        transacao.setHoraTransacao(new Date());
        transacao.setIdConta(conta);
        transacaoRepository.save(transacao);
    }

    public void bloqueio(Long idConta){
        Contas conta = contaService.getOne(idConta);
        conta.setFlagAtivo(false);
        contaService.save(conta);
    }

    public void desbloqueio(Long idConta){
        Contas conta = contaService.getOne(idConta);
        conta.setFlagAtivo(true);
        contaService.save(conta);
    }

    public String saque(SaqueDTO saqueDTO){
        String confirmacao = "";
        Contas conta = contaService.getOne(saqueDTO.getIdconta());
        if(conta.getLimiteSaqueDiario().doubleValue() <= saqueDTO.getValorsaque().doubleValue() ||
                conta.getSaldo().doubleValue() <= saqueDTO.getValorsaque().doubleValue()) {
            NumberFormat pf = NumberFormat.getCurrencyInstance();
            conta.setSaldo(conta.getSaldo().subtract(saqueDTO.getValorsaque()));
            contaService.save(conta);
            Transacoes transacao = new Transacoes();
            transacao.setValor(saqueDTO.getValorsaque());
            transacao.setDataTransacao(new Date());
            transacao.setHoraTransacao(new Date());
            transacao.setIdConta(conta);
            transacaoRepository.save(transacao);
            confirmacao = "Operação realizada com sucesso! Saldo atual: R$" + pf.format(conta.getSaldo());
        } else {
            confirmacao = "Operação não realizada, saldo ou limite de saque insuficiente.";
        }
        return confirmacao;
    }

    public void transacaoCartao(TransacoesCartaoDTO transacoesCartaoDTO){
        Transacoes transacao = new Transacoes();
        transacao.setValor(transacoesCartaoDTO.getValor());
        transacao.setDataTransacao(transacoesCartaoDTO.getDataTransacao());
        transacao.setHoraTransacao(new Date());
        transacao.setCartao(transacoesCartaoDTO.getCartao());
        transacaoRepository.save(transacao);
    }

}
