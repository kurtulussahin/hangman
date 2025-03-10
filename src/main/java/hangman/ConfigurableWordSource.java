package hangman;

import java.util.Random;

class ConfigurableWordSource implements WordSource {
    private final String[] words;
    private final Random random;

    public ConfigurableWordSource(String[] words) {
        this(words, new Random());
    }

    public ConfigurableWordSource(String[] words, Random random) {
        this.words = words.clone();
        this.random = random;
    }

    @Override
    public String randomWord() {
        return words[random.nextInt(words.length)];
    }
}
