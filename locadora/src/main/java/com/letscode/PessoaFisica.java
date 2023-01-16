package com.letscode;

import java.math.BigDecimal;

public class PessoaFisica implements Pessoa {

    @Override
    public BigDecimal getDesconto(int dias) {
        return dias > 5
                ? new BigDecimal("0.05")
                : BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    

}
