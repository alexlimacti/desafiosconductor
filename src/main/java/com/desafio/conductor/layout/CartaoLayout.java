package com.desafio.conductor.layout;

public class CartaoLayout {

    private Coluna cartao;
    private Coluna dataTransacao;
    private Coluna valor;

    public void inicialize(){
        cartao = new Coluna(1,16,16,TipoColuna.numerico,"0000000000000000");
        dataTransacao = new Coluna(17,24,8,TipoColuna.numerico,"00000000");
        valor  = new Coluna(25,36,11,TipoColuna.numerico,"00000000000");
    }

    public String getLinha(){
        String linha = cartao.getValor() + dataTransacao.getValor() + valor.getValor();
        return linha;
    }

    public Coluna getCartao() {
        return cartao;
    }

    public void setCartao(Coluna cartao) {
        this.cartao = cartao;
    }

    public Coluna getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Coluna dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Coluna getValor() {
        return valor;
    }

    public void setValor(Coluna valor) {
        this.valor = valor;
    }
}
