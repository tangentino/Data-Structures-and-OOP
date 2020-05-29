import java.math.BigInteger;

public class Fib {
    static BigInteger fibbonaci(int n) { // returns n-th term of fib sequence
        BigInteger previous = BigInteger.valueOf(0); 
        BigInteger current = BigInteger.valueOf(1); 
        BigInteger sum = BigInteger.valueOf(1);
        for (int i = 0; i < n - 1; i++) {
            sum = previous.add(current);
            previous = current;
            current = sum;
        }        
        return current;
    }
    
    static int digits(BigInteger n) { // returns number of digits
        return String.valueOf(n).length();
    }

    public static int firstNDigit(int n) {
        int i = 1;
        while (digits(fibbonaci(i)) < n) {
            i++;
        }
        return i;
    }
}