import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator ob1 = new OffByN(1);
    static CharacterComparator ob2 = new OffByN(2);
    static CharacterComparator ob3 = new OffByN(3);
    static CharacterComparator ob4 = new OffByN(4);
    static CharacterComparator ob5 = new OffByN(5);
    static CharacterComparator ob6 = new OffByN(6);

    @Test
    public void testing() {
        assertEquals(true, ob5.equalChars('a','f'));
        assertEquals(true, ob5.equalChars('d','i'));
        assertEquals(true, ob5.equalChars('f','a'));
        assertEquals(false, ob5.equalChars('a','e'));
        assertEquals(false, ob5.equalChars('a','z'));
        assertEquals(false, ob5.equalChars('d','f'));
    }
}
