public class BinaryTreeNode {
  public int key;
  public BinaryTreeNode left, right;
  
  public BinaryTreeNode(BinaryTreeNode left_,
                        int key_,
                        BinaryTreeNode right_) {
    this.left = left_;
    this.key = key_;
    this.right = right_;
  }
  
  public BinaryTreeNode(int key_) {
    this(null, key_, null);
  }

  public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.left = new BinaryTreeNode(20);
    root.right =new BinaryTreeNode( 9);
    System.out.println(root);
  }
}
