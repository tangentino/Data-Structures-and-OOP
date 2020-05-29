// MPORTANT: ncomment this file after you have implemented OffByOne

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testing() {
        assertEquals(true, offByOne.equalChars('a','b'));
        assertEquals(true,offByOne.equalChars('r','q'));
        assertEquals(true,offByOne.equalChars('c','d'));
        assertEquals(true,offByOne.equalChars('e','d'));
        assertEquals(true,offByOne.equalChars('b','a'));
        assertEquals(true,offByOne.equalChars('r','s'));
        assertEquals(true,offByOne.equalChars('f','e'));
        assertEquals(true,offByOne.equalChars('l','k'));
        assertEquals(true,offByOne.equalChars('a','a'));
        assertEquals(true,offByOne.equalChars('k','l'));
        assertEquals(true,offByOne.equalChars('f','e'));

        assertEquals(false, offByOne.equalChars('a','e'));
        assertEquals(false, offByOne.equalChars('z','a'));
        assertEquals(false, offByOne.equalChars('a','a'));
        assertEquals(false, offByOne.equalChars('a','d'));
        assertEquals(false, offByOne.equalChars('l','j'));
        assertEquals(false, offByOne.equalChars('m','o'));
    }
} 

