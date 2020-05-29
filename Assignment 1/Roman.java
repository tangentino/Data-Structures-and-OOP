public class Roman {
    static int romanValue(char x) { // Helper function that takes a single Roman char and converts it to an int
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
    public static int romanToInt(String romanNum) {
        int ans = 0;
        for (int i = 0; i<romanNum.length(); i++) {
            if ((i < romanNum.length()-1) && ( romanValue(romanNum.charAt(i)) < romanValue(romanNum.charAt(i+1)) ))
                ans -= romanValue(romanNum.charAt(i));
            else 
                ans += romanValue(romanNum.charAt(i));       
        }
        return ans;
    }
}



