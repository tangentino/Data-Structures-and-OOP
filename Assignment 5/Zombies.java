import java.util.Arrays;
public class Zombies {
    static int inversions = 0;

    static int[] mergeSort(int[] a) {
        int n=a.length;
        if (n <= 1) return a;
        int[] left = Arrays.copyOfRange(a, 0, n/2);
        int[] right = Arrays.copyOfRange(a, n/2, n);
        return merge(mergeSort(left), mergeSort(right));
    }

    static int[] merge(int[] a, int[] b) {
        int n = a.length+b.length;
        int[] out = new int[n];
        int ai=0,bi=0,oi=0;
        int x = 0;
        while (ai < a.length && bi < b.length) {
            if (a[ai] > b[bi]) { 
                out[oi++] = a[ai++]; 
            }
            else { 
                x += a.length - ai;
                System.out.println("Inversion: "+a[ai]+","+b[bi]);
                out[oi++] = b[bi++]; 
            }
        }
        
        while (ai<a.length) {
            out[oi++] = a[ai++];
        }
        while (bi<b.length) {

            out[oi++] = b[bi++];
        }
        inversions += x;
        System.out.println("Final Inversions = "+x);
        return out;
    }

    public static void main(String[] args) {
        int[] test = {1,7,22,13,25,4,10,34,16,28,19,31};
        int[] test2 = {3,1,4,2};
        int[] test3 = {4,5,7,11};
        System.out.println(Arrays.toString(mergeSort(test)));
    }
        
        
}