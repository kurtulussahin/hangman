package hangman;

class LoggingWordSource implements WordSource {
    private final WordSource source;

    public LoggingWordSource(WordSource source) {
        this.source = source;
    }

    @Override
    public String randomWord() {
        String word = source.randomWord();
        System.out.println("Selected word: " + word);
        return word;
    }
}
