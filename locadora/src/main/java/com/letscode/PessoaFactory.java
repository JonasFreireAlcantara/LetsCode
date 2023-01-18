package com.letscode;

import java.util.Random;

public class PessoaFactory implements AbstractFactory<Pessoa> {

    @Override
    public Pessoa createRandom() {
        int numero = new Random().nextInt(2);

        switch(numero) {
            case 0:
                return new PessoaFisica();
            case 1:
                return new PessoaJuridica();
        }

        return null;
    }

}
