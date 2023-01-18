package com.letscode;

import java.util.Random;

public class VeiculoFactory implements AbstractFactory<Veiculo> {

    @Override
    public Veiculo createRandom() {
        int numero = new Random().nextInt(3);

        switch(numero) {
            case 0:
                return new VeiculoPequeno();
            case 1:
                return new VeiculoMedio();
            default:
                return new VeiculoSUV();
        }
    }

}
