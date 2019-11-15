package com.desafio.conductor.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransacoesCartaoDTO {

    private Date dataTransacao;
    private Date horaTransacao;
    private BigDecimal valor;
    private Long cartao;

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Date getHoraTransacao() {
        return horaTransacao;
    }

    public void setHoraTransacao(Date horaTransacao) {
        this.horaTransacao = horaTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getCartao() {
        return cartao;
    }

    public void setCartao(Long cartao) {
        this.cartao = cartao;
    }
}
