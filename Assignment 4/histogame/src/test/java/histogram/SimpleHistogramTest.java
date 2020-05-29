package histogram;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class SimpleHistogramTest {

    @Test
    public void testHistogram() {
        Character[] target = {'a','b','c','a'};
        Character[] target2 = {'b','c','a'};
        Histogram<Character> h = new SimpleHistogram<>(target);
        Iterator<Character> iter = h.iterator();
        int elemCount = 0;
        while(iter.hasNext()) {
            iter.next();
            elemCount++;
        }
        Histogram<Character> copy = new SimpleHistogram<>(target2);
        System.out.println(h.toString());
        System.out.println(copy.toString());
        System.out.println(h.toString());
        System.out.println(copy.toString());
        assertEquals(3, elemCount);
        assertEquals(2, h.getCount('a'));
        assertEquals(1, h.getCount('b'));
        assertEquals(1, h.getCount('c'));
        assertEquals(4, h.getTotalCount());
        assertEquals(h,copy);
    }
}
