package com.letscode;

import java.math.BigDecimal;

public class VeiculoMedio implements Veiculo {

    @Override
    public BigDecimal precoBase() {
        return new BigDecimal("150");
    }

    @Override
    public String toString() {
        return this.getClassName();
    }

    

}
