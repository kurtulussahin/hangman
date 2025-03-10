package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class HangmanCLI {
    private final InputStream input;
    private final OutputStream output;
    private final HangmanGame game;

    public HangmanCLI(InputStream input, OutputStream output, HangmanGame game) {
        this.input = input;
        this.output = output;
        this.game = game;
    }

    public void start() {
        try (PrintStream out = new PrintStream(output);
             Scanner scanner = new Scanner(input)) {
            HangmanGame currentGame = game;
            while (!currentGame.isGameOver()) {
                out.print("Guess a letter: ");
                char guess = scanner.next().charAt(0);
                currentGame = currentGame.playRound(guess, out);
                if(currentGame.isWon()) {
                    break;
                }
                out.println("The word: " + currentGame.maskedWord());
                currentGame.printMistakes(out);

            }
            out.println(currentGame.isWon() ? "You won!" : "You lost.");
        }
    }
}
