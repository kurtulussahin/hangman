package hangman;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        new HangmanCLI(System.in, System.out,
                new HangmanGame(
                        new LoggingWordSource(
                                new ConfigurableWordSource(
                                        new String[]{"simplicity", "equality", "grandmother", "neighborhood", "relationship", "mathematics", "university", "explanation"})),
                        5)).start();
    }
}