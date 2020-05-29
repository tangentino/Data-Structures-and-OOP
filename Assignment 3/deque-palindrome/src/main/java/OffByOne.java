public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return (Character.getNumericValue(x) - Character.getNumericValue(y) == 1 ||  Character.getNumericValue(y) - Character.getNumericValue(x) == 1);
    }
}