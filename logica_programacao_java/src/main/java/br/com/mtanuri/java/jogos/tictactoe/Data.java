package br.com.mtanuri.java.jogos.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private String word;
    private String theme;
    private List<Character> chosenLetters;
    private int penaltiesNumber;
    private int matchesNumber;
    private int numberOfNeededMatches;

    public Data() {
        this.chosenLetters = new ArrayList<>();
    }

    public void addNewChosenLetter(Character chosenLetter) {
        this.chosenLetters.add(chosenLetter);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        this.numberOfNeededMatches = this.countNonSpecialCharacters(word);
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Character> getChosenLetters() {
        return chosenLetters;
    }

    public int getPenaltiesNumber() {
        return penaltiesNumber;
    }

    public void incrementPenalty() {
        this.penaltiesNumber += 1;
    }

    public int getMatchesNumber() {
        return matchesNumber;
    }

    public void incrementMatches(int newMatchesNumber) {
        this.matchesNumber += newMatchesNumber;
    }

    public int getNumberOfNeededMatches() {
        return numberOfNeededMatches;
    }

    private int countNonSpecialCharacters(String word) {
        int counter = 0;

        for (Character letter : word.toCharArray()) {
            if (Character.isLetterOrDigit(letter)) {
                counter++;
            }
        }

        return counter;
    }

}
