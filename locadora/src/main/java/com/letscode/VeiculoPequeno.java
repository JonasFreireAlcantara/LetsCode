package com.letscode;

import java.math.BigDecimal;

public class VeiculoPequeno implements Veiculo {
    
    @Override
    public BigDecimal precoBase() {
        return new BigDecimal("100");
    }

    @Override
    public String toString() {
        return this.getClassName();
    }
}
