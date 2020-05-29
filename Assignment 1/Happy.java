import java.util.ArrayList;
import java.util.Arrays;

public class Happy {
    public static long sumOfDigitsSquared(long n) {
        long ans = 0;
        while (n > 0) {
            ans += (n%10) * (n%10);
            n /= 10;
        }
        return ans;
    }

    public static boolean isHappy(long n) {
        long nSquares = sumOfDigitsSquared(sumOfDigitsSquared(n));
        while (nSquares != 1) {
            nSquares = sumOfDigitsSquared(nSquares);
            if (nSquares == 4) 
                return false;
        }
        return true;
    }

    public static long[] firstK(int k) {
        ArrayList<Long> happyList = new ArrayList<Long>();
        long i = 1;
        while (happyList.size() < k) {
            if (isHappy(i))
                happyList.add(i);
                i++;
        }
        long[] ans = new long[happyList.size()];
        for (int j = 0; j < happyList.size(); j++) {
            ans[j] = happyList.get(j);
        }
        return ans;
    }
}