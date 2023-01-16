package com.letscode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public final class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        List<Aluguel<Veiculo>> alugueis = new ArrayList<>();

        for (int k = 0; k < 10; k++) {
            Aluguel<Veiculo> aluguel = new Aluguel<>();
            aluguel.setBem(obterVeiculoAleatorio());
            aluguel.setPessoa(obterPessoaAleatoria());
            aluguel.setDias(new Random().nextInt(20) + 1);

            alugueis.add(aluguel);
        }

        alugueis.forEach(aluguel -> System.out.println(aluguel));
    }

    private static Veiculo obterVeiculoAleatorio() {
        int numero = new Random().nextInt(3);

        switch(numero) {
            case 0:
                return new VeiculoPequeno();
            case 1:
                return new VeiculoMedio();
            case 2:
                return new VeiculoSUV();
        }

        return null;
    }

    private static Pessoa obterPessoaAleatoria() {
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
