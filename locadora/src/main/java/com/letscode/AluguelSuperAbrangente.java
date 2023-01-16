package com.letscode;

import java.math.BigDecimal;

public class AluguelSuperAbrangente {

    private Bem bem;
    private Pessoa pessoa;
    private int dias;

    public BigDecimal calculoAluguel() {
        BigDecimal valorDesconto = bem
                .precoBase()
                .multiply(pessoa.getDesconto(this.dias));

        return bem
                .precoBase()
                .subtract(valorDesconto)
                .multiply(BigDecimal.valueOf(this.dias));
    }

    public Bem getBem() {
        return bem;
    }

    public void setBem(Bem bem) {
        this.bem = bem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    
}

