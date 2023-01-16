package com.letscode;

import java.math.BigDecimal;

public class PessoaJuridica implements Pessoa {

    @Override
    public BigDecimal getDesconto(int dias) {
        return dias > 3
                ? new BigDecimal("0.1")
                : BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
