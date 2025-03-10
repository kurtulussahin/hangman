package hangman;

interface IWorld {
    IWorld guess(char letter);
    boolean isFullyRevealed();
    String masked();
}
