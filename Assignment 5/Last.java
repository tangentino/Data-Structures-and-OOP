import java.util.Arrays;

public class Last {
    public static Integer binarySearchLast(int[] a, int k) {
        return lastHelper(a,0,a.length,k);
    }

    public static Integer lastHelper(int[] a, int low, int high, int k) {
        if (low >= high) {
            return null;
        }
        else {
            int mid = (low + high)/2;
            if (a[high-1] == k) {
                return high-1;
            }
            else if (((a[mid] == k) && (a[mid+1] != k))) {
                return mid;
            }
            else if (k < a[mid]) {
                return lastHelper(a,low,mid,k);
            }
            else {
                return lastHelper(a,mid+1,high,k);
            }
        }
    }
}