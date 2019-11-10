package com.desafio.conductor.layout;

public class Coluna {

    private int quantPosicao;
    private TipoColuna tipo;
    private String defalt;
    private int posicaoInicial;
    private int posicaoFinal;
    private String valor;

    public Coluna( int posicaoInicial,  int posicaoFinal, int quantPosicao,
                   TipoColuna tipo, String defalt) {
        super();
        this.quantPosicao = quantPosicao;
        this.tipo = tipo;
        this.defalt = defalt;
        this.posicaoInicial = posicaoInicial;
        this.posicaoFinal = posicaoFinal;
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        String aux = valor;
        aux = substituirCaracteresEspecial(aux);
        if(aux.length() > quantPosicao){
            aux = aux.substring(0, quantPosicao);
        }
        if(tipo.equals(TipoColuna.numerico)){
            int quantAtual = aux.length();
            for(int c = 0 + quantAtual ; c < quantPosicao ; c++){
                aux = "0".concat(aux);
            }
        }else{
            int quantAtual = aux.length();
            for(int c = 0 + quantAtual ; c < quantPosicao ; c++){
                aux = aux.concat(" ");
            }
        }
        this.valor = aux;
    }

    public String substituirCaracteresEspecial(String s){
        String retorno = s.toUpperCase();
        retorno =  retorno.replace("Ç", "C");
        retorno =  retorno.replace("Á", "A");
        retorno =  retorno.replace("À", "A");
        retorno =  retorno.replace("Â", "A");
        retorno =  retorno.replace("Ã", "A");
        retorno =  retorno.replace("Ó", "O");
        retorno =  retorno.replace("Ò", "O");
        retorno =  retorno.replace("Ô", "O");
        retorno =  retorno.replace("Õ", "O");
        retorno =  retorno.replace("Í", "I");
        retorno =  retorno.replace("`", "");
        retorno =  retorno.replace("É", "E");
        retorno =  retorno.replace("È", "E");
        retorno =  retorno.replace("Ê", "E");
        retorno =  retorno.replace("Ú", "E");
        return retorno;
    }

    public int getQuantPosicao() {
        return quantPosicao;
    }
    public void setQuantPosicao(int quantPosicao) {
        this.quantPosicao = quantPosicao;
    }
    public TipoColuna getTipo() {
        return tipo;
    }
    public void setTipo(TipoColuna tipo) {
        this.tipo = tipo;
    }
    public String getDefalt() {
        return defalt;
    }
    public void setDefalt(String defalt) {
        this.defalt = defalt;
    }
    public int getPosicaoInicial() {
        return posicaoInicial;
    }
    public void setPosicaoInicial(int posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }
    public int getPosicaoFinal() {
        return posicaoFinal;
    }
    public void setPosicaoFinal(int posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }

}
