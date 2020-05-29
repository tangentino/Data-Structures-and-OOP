import java.util.Arrays;

public class MakeTree {
    public static BinaryTreeNode buildBST_helper(int[] arr, int high, int low) {
        if (low > high) {
            return null;
        }
        int mid = (high + low)/2;
        BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
        root.left = buildBST_helper(arr, mid-1, low); // T(n/2)
        root.right = buildBST_helper(arr, high, mid+1);// T(n/2)

        return root; // 2T(n/2) + O(1) = O(n) complexity
    }

    public static BinaryTreeNode buildBST(int[] keys) {
        Arrays.sort(keys); // O(nlogn)
        return buildBST_helper(keys, keys.length-1, 0); // O(n)
    }

    public static void main(String[] args) {
        int[] test = {1,6,3,7,8,2,19,22}; // {1,2,3,6,7,8,19,22}
        BinaryTreeNode n = buildBST(test);
        System.out.println(n.right.key);
    }

}