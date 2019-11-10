package com.desafio.conductor.dto;

import java.math.BigDecimal;

public class SaqueDTO {

    private Long idconta;
    private BigDecimal valorsaque;

    public Long getIdconta() {
        return idconta;
    }

    public void setIdconta(Long idconta) {
        this.idconta = idconta;
    }

    public BigDecimal getValorsaque() {
        return valorsaque;
    }

    public void setValorsaque(BigDecimal valorsaque) {
        this.valorsaque = valorsaque;
    }
}
