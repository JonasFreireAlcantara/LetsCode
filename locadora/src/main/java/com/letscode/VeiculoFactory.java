package com.letscode;

import java.util.Random;

public class VeiculoFactory implements AbstractFactory<Veiculo> {

    private Random random;

    public VeiculoFactory(Random random) {
        this.random = random;
    }

    @Override
    public Veiculo createRandom() {
        int numero = this.random.nextInt(3);

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
