public class OffByN implements CharacterComparator {

    private int diff;

    public OffByN(int N) {
        this.diff = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        return (Character.getNumericValue(x) - Character.getNumericValue(y) == diff ||  Character.getNumericValue(y) - Character.getNumericValue(x) == diff);
    }
}