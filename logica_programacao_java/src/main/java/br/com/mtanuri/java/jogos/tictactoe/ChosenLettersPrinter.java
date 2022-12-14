package br.com.mtanuri.java.jogos.tictactoe;

public class ChosenLettersPrinter {

    public static void show(Data data) {
        StringBuilder stringBuilder = new StringBuilder("Letras já escolhidas: ");

        for (Character chosenLetter : data.getChosenLetters()) {
            stringBuilder.append(chosenLetter);
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
    }

}
