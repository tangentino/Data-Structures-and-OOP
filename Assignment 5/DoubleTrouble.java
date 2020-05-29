import java.util.Arrays;
public class DoubleTrouble {
    
    public static int findRank(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static int rank(int[] A, int[] B, int e) {
        return (findRank(A,e)+findRank(B,e));
    }

    public static Integer findKthElement(int[] arr, int k) {
        if ( k >= arr.length || k < 0) { return null; }
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low+high)/2;
            if (mid >= k) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return arr[ans];

    }

    // public static Integer select(int[] A, int[] B, int k) {

    // }

    public static void main(String[] args) {
        // int[] a = {10,21};
        // int[] b = {32,53,54};
        int[] arr = {10,21,32,53,54};
        System.out.println(findKthElement(arr, 4));
        // System.out.println(rank(a,b,9)); // 0
        // System.out.println(rank(a,b,10)); // 0
        // System.out.println(rank(a,b,11)); // 1
        // System.out.println(rank(a,b,21)); // 1
        // System.out.println(rank(a,b,22)); // 2
        // System.out.println(rank(a,b,32)); // 2
        // System.out.println(rank(a,b,33)); // 3
        // System.out.println(rank(a,b,53)); // 3
        // System.out.println(rank(a,b,54)); // 4
        // System.out.println(rank(a,b,55)); // 5

    }
}
