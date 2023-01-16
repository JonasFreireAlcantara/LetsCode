package com.letscode;

public interface Veiculo extends Bem {

    default String getClassName() {
        return this.getClass().getSimpleName();
    }

}
