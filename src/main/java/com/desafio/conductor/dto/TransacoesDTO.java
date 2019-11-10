package com.desafio.conductor.dto;

public class TransacoesDTO {

    private String dataTransacao;
    private String horaTransacao;
    private String valor;

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getHoraTransacao() {
        return horaTransacao;
    }

    public void setHoraTransacao(String horaTransacao) {
        this.horaTransacao = horaTransacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
