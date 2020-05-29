public class MinMax {

    public static double minMaxAverage(int[] numbers) {
        int i;
        int min;
        int max;
        if (numbers.length%2 == 0) {
            if (numbers[0] > numbers[1]) {
                max = numbers[0];
                min = numbers[1];
            }
            else {
                max = numbers[1];
                min = numbers[0];
            }
            i = 2;
        }
        else {
            max = numbers[0]; 
            min = numbers[0];
            i = 1;
        }
        while (i < numbers.length - 1) {
            if (numbers[i] > numbers[i+1]) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
                if (numbers[i+1] < min){
                    min = numbers[i+1];
                }
            }
            else {
                if (numbers[i+1] > max) {
                    max = numbers[i+1];
                }
                if (numbers[i] < min) {
                    min = numbers[i];
                }
            }
            i += 2;
        }
        int myMin = min;
        int myMax = max;
        
      
        return (myMin + myMax)/2.0;
    }

    public static void main(String[] arg) {
        int[] a = {12,5,7,8,2,3,4,5,7,2,1,5,2,99};
        int[] b = {2,3,6,5,4,1,9,7,8,2};
        int[] c = {50};
        System.out.println(minMaxAverage(a));
        System.out.println(minMaxAverage(b));
        System.out.println(minMaxAverage(c));
    }
    
}