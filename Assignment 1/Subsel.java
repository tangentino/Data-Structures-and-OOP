import java.util.Arrays;

public class Subsel {
    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        int[] temp;
        int[] ans;
        temp = new int[a.length];
        int ansLength = 0;
        if (stride > 0) {
            for (int i = 0; beginWith+i*stride < a.length; i++) {
                temp[i] = a[beginWith+i*stride];
                ansLength++;
            }   
        }

        else if (stride < 0) {
            for (int i = 0; beginWith+i*stride >= 0; i++) {
                temp[i] = a[beginWith+i*stride];
                ansLength++;
            }
        }

        ans = new int[ansLength];
        for (int j = 0; j < ansLength; j++) {
            ans[j] = temp[j];
        }

        return ans;
    }

    public static int[] takeEvery(int[] a,int stride) {
        return takeEvery(a, stride, 0);
    }
}