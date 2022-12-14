package br.com.mtanuri.java.jogos.tictactoe;

public class Run {
    
    public static void main(String[] args) {
        Game game = new Game();

        game.initialize();

        while(!game.isGameOver()) {
            game.showFrame();
            game.runNextRound();
        }
        game.showFrame();

        System.out.println();
        if (game.isWin()) {
            System.out.println("*** YOU WIN ***");
        } else {
            System.out.println("*** YOU LOSE ***");
        }
    }

}
