package com.letscode;

import java.util.Random;

public class PessoaFactory implements AbstractFactory<Pessoa> {

    private Random random;

    public PessoaFactory(Random random) {
        this.random = random;
    }

    @Override
    public Pessoa createRandom() {
        int numero = this.random.nextInt(2);

        switch(numero) {
            case 0:
                return new PessoaFisica();
            case 1:
                return new PessoaJuridica();
        }

        return null;
    }

}
