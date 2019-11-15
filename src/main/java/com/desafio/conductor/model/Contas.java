package com.desafio.conductor.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name= "contas")
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Pessoas idPessoa;
    private BigDecimal saldo;
    private BigDecimal limiteSaqueDiario;
    private boolean flagAtivo;
    private Integer tipoConta;
    private Long cartao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    public Contas(Pessoas idPessoa, BigDecimal saldo, BigDecimal limiteSaqueDiario, boolean flagAtivo, TipoConta tipoConta, Date dataCriacao, Long cartao) {
        super();
        this.idPessoa = idPessoa;
        this.saldo = saldo;
        this.limiteSaqueDiario = limiteSaqueDiario;
        this.flagAtivo = flagAtivo;
        this.tipoConta = (tipoConta == null) ? null : tipoConta.getCod();
        this.dataCriacao = dataCriacao;
        this.cartao = cartao;
    }

    public Contas(){

    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoas getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoas idPessoa) {
        this.idPessoa = idPessoa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public boolean isFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public TipoConta getTipoConta() {
        return TipoConta.toEnum(tipoConta);
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta.getCod();
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getCartao() {
        return cartao;
    }

    public void setCartao(Long cartao) {
        this.cartao = cartao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contas contas = (Contas) o;
        return id.equals(contas.id);
    }
}
