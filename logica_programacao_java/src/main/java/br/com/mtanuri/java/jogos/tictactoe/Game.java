package br.com.mtanuri.java.jogos.tictactoe;

import java.io.Console;
import java.util.Scanner;

public class Game {

    private Data data;
    private Console console = System.console();
    private Scanner scanner = new Scanner(System.in);

    private final int MAX_PENALTIES = 6;

    public Game() {
        this.data = new Data();
    }

    public void initialize() {
        System.out.println("Digite o nome da palavra a ser descoberta:");
        String word = (new String(this.console.readPassword())).toUpperCase();

        System.out.println("Digite agora o tema ao qual a palavra está associado:");
        String theme = this.scanner.nextLine();

        this.data.setWord(word);
        this.data.setTheme(theme);
    }
    
    public void showFrame() {
        System.out.println("\n-------------------------------\n");
        GallowsPrinter.show(this.data);
        
        System.out.println();
        WordPrinter.show(this.data);
        System.out.println("\nTema: " + this.data.getTheme());
        ChosenLettersPrinter.show(this.data);

        System.out.println("\nErros: " + this.data.getPenaltiesNumber() + "\n");
    }
    
    public void runNextRound() {
        System.out.print(">>> ");
        Character newChosenLetter = this.scanner.next()
            .toUpperCase()
            .charAt(0);

        if (isAlreadyChosenLetter(newChosenLetter)) {
            System.out.println("Esta letra já foi digitada ...");
            return;
        }
        else if (isSpecialCharacter(newChosenLetter)) {
            System.out.println("Este carácter não é válido ...");
            return;
        }

        int matchesNumber = numberOfLetterMatches(newChosenLetter);
        if (matchesNumber == 0) {
            this.data.incrementPenalty();
        } else {
            this.data.incrementMatches(matchesNumber);
        }

        this.data.addNewChosenLetter(newChosenLetter);
    }

    public static boolean isSpecialCharacter(Character character) {
        return !Character.isLetterOrDigit(character);
    }
    
    private boolean isAlreadyChosenLetter(Character newChosenLetter) {
        return this.data.getChosenLetters().contains(newChosenLetter);
    }

    public boolean isGameOver() {
        return isWin() || isLose();
    }

    public boolean isWin() {
        return this.data.getMatchesNumber() == this.data.getNumberOfNeededMatches();
    }

    public boolean isLose() {
        return this.data.getPenaltiesNumber() == MAX_PENALTIES;
    }

    private int numberOfLetterMatches(Character letter) {
        return (int) this.data.getWord().chars().filter(character -> character == letter).count();
    }

}
