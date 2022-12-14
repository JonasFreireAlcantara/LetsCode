package br.com.mtanuri.java.jogos.tictactoe;

public class GallowsPrinter {

    private static String[] designs = {
        "|   \n|      \n|     \n|",
        "|  O\n|      \n|     \n|",
        "|  O\n|  |   \n|     \n|",
        "|  O\n| /|   \n|     \n|",
        "|  O\n| /|\\ \n|     \n|",
        "|  O\n| /|\\ \n| /   \n|",
        "|  O\n| /|\\ \n| / \\\n|"
    };

    public static void show(Data data) {
        String design = designs[data.getPenaltiesNumber()];

        System.out.println("+--+");
        System.out.println(design);
    }

}
