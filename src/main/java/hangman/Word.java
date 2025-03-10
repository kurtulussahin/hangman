package hangman;

import java.util.Arrays;
import java.util.stream.IntStream;

class Word implements IWorld {
    private final String value;
    private final boolean[] visible;

    public Word(String value, boolean[] visible) {
        this.value = value;
        this.visible = visible.clone();
    }

    public Word(String value) {
        this(value, new boolean[value.length()]);
    }

    @Override
    public IWorld guess(char letter) {
        boolean[] newVisible = visible.clone();
        boolean hit = false;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == letter) {
                newVisible[i] = true;
                hit = true;
            }
        }
        return new Word(value, newVisible);
    }

    @Override
    public boolean isFullyRevealed() {
        return IntStream.range(0, visible.length).allMatch(i -> visible[i]);
    }

    @Override
    public String masked() {
        StringBuilder maskedWord = new StringBuilder();
        IntStream.range(0, value.length())
                .forEach(i -> maskedWord.append(visible[i] ? value.charAt(i) : '?'));
        return maskedWord.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word other = (Word) obj;
        return value.equals(other.value) && Arrays.equals(visible, other.visible);
    }
}
