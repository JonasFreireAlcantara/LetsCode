package com.letscode;

import java.math.BigDecimal;

public class VeiculoSUV implements Veiculo {
    
    @Override
    public BigDecimal precoBase() {
        return new BigDecimal("200");
    }

    @Override
    public String toString() {
        return this.getClassName();
    }

}
