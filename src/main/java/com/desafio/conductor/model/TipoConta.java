package com.desafio.conductor.model;

public enum TipoConta {
    CORRENTE(1, "Corrente"),
    POUPANCA(2, "Poupança");

    private int cod;
    private String descricao;

    private TipoConta(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoConta toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (TipoConta x : TipoConta.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
