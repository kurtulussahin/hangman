package hangman;

import java.io.PrintStream;

class HangmanGame {
    private final IWorld word;
    private final int maxMistakes;
    private final int mistakes;

    public HangmanGame(WordSource source, int maxMistakes) {
        this(new Word(source.randomWord()), maxMistakes, 0);
    }

    private HangmanGame(IWorld word, int maxMistakes, int mistakes) {
        this.word = word;
        this.maxMistakes = maxMistakes;
        this.mistakes = mistakes;
    }

    public HangmanGame playRound(char letter, PrintStream out) {
        IWorld newWord = word.guess(letter);
        boolean hit = !newWord.masked().equals(word.masked());
        int newMistakes = hit ? mistakes : mistakes + 1;
        if (hit) {
            out.println("Hit!");
        }
        return new HangmanGame(newWord, maxMistakes, newMistakes);
    }

    public boolean isGameOver() {
        return  mistakes >= maxMistakes;
    }

    public boolean isWon() {
        return word.isFullyRevealed();
    }

    public String maskedWord() {
        return word.masked();
    }

    public void printMistakes(PrintStream out) {
        out.printf("Mistakes: %d/%d%n", mistakes, 5);

    }
}
