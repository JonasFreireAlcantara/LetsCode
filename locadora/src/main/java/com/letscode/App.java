package com.letscode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public final class App {

    public static void main(String[] args) {
        Random random = new NossaRandom();
        Random randomEstatico = new RandomEstatica();

        caso(random, randomEstatico);
        System.out.println("===============");
        caso(randomEstatico, random);
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void caso(Random random1, Random random2) {
        List<Aluguel<Veiculo>> alugueis = new ArrayList<>();

        VeiculoFactory veiculoFactory = new VeiculoFactory(random1);
        PessoaFactory pessoaFactory = new PessoaFactory(random2);

        for (int k = 0; k < 10; k++) {
            Aluguel<Veiculo> aluguel = new Aluguel<>();
            aluguel.setBem(veiculoFactory.createRandom());
            aluguel.setPessoa(pessoaFactory.createRandom());
            aluguel.setDias(new Random().nextInt(20) + 1);

            alugueis.add(aluguel);
        }

        alugueis.forEach(aluguel -> System.out.println(aluguel));
    }

}
