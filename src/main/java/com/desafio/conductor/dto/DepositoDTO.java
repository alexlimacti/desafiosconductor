package com.desafio.conductor.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

public class DepositoDTO {

    private Long idconta;
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    private Date data;

    public Long getIdconta() {
        return idconta;
    }

    public void setIdconta(Long idconta) {
        this.idconta = idconta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
