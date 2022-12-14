package br.com.mtanuri.java.jogos.tictactoe;

import java.util.List;

public class WordPrinter {

    private static final Character WILD_CHARACTER = '_';

    public static void show(Data data) {
        String word = data.getWord();
        List<Character> chosenLetters = data.getChosenLetters();

        StringBuilder result = new StringBuilder();

        for (Character wordLetter : word.toCharArray()) {

            if (characterShouldBeShow(wordLetter, chosenLetters)) {
                result.append(wordLetter);
            } else {
                result.append(WordPrinter.WILD_CHARACTER);
            }

            result.append(" ");
        }

        System.out.println(result.toString());
    }

    public static boolean characterShouldBeShow(Character wordLetter, List<Character> chosenLetters) {
        return Game.isSpecialCharacter(wordLetter) || chosenLetters.contains(wordLetter);
    }

}
