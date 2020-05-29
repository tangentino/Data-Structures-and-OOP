import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Uproot {

    public static void treeToMapHelper(BinaryTreeNode node, HashMap<Integer,Integer> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            map.put(node.left.key,node.key);
        }
        if (node.right != null) {
            map.put(node.right.key,node.key);
        }
        treeToMapHelper(node.left,map);
        treeToMapHelper(node.right,map);
    }

    public static HashMap<Integer,Integer> treeToParentMap(BinaryTreeNode T) {
        HashMap<Integer,Integer> ans = new HashMap<>();
        treeToMapHelper(T,ans);
        return ans;
    }
    public static Integer findRootValue(Map<Integer,Integer> map) {
        for (Integer value : map.values()) {
            if (!map.containsKey(value)) {
                return value;
            }
        }
        return 0;
    }
    public static BinaryTreeNode parentMapToTree(Map<Integer,Integer> map) {
        Map<Integer,BinaryTreeNode> createdNodes = new HashMap<>(); // HashMap<Key, Node>
        Integer rootInt = findRootValue(map);
        BinaryTreeNode root = new BinaryTreeNode(rootInt);
        createdNodes.put(rootInt,root);

        for (Integer child : map.keySet()) {
            Integer parent = map.get(child);
            if (!createdNodes.containsKey(parent)) { // if node is not already in the created nodes
                BinaryTreeNode node = new BinaryTreeNode(new BinaryTreeNode(child),parent,null);
                createdNodes.put(parent,node);
            }
            else {
                BinaryTreeNode node = createdNodes.get(parent);
                if (node.left != null) {
                    if (createdNodes.containsKey(child)) {
                        node.right = createdNodes.get(child);
                    }
                    else {node.right = new BinaryTreeNode(child);}
                    createdNodes.put(child,node.right);
                }
                else {
                    if (createdNodes.containsKey(child)) {
                        node.left = createdNodes.get(child);
                    }
                    else {node.left = new BinaryTreeNode(child);}
                    createdNodes.put(child,node.left);   
                }
                createdNodes.put(parent,node);
            }
        }
        return root;


    }
}