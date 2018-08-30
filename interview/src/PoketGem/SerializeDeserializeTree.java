package PoketGem;

import java.util.*;

/**
 * Created by lingyanjiang on 17/2/28.
 */
class TreeNode2<T> {
    T val;
    TreeNode2 left;
    TreeNode2 right;
    public TreeNode2(T val) {
        this.val = val;
    }
}


public class SerializeDeserializeTree {
    public String serialize(TreeNode2 root) {
        if (root == null) return "#,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public TreeNode2 deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String [] splited = data.split(",");
        Queue<String> q = new LinkedList<>();
        for (String s: splited) {
            q.add(s);
        }
        return helper(q);
    }

    private TreeNode2 helper(Queue<String> q) {
        TreeNode2 root = null;
        if (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.equals("#")) return null;
            if (cur.isEmpty())  {
                cur = q.poll();
            }
            root = new TreeNode2(cur);
            root.left = helper(q);
            root.right = helper(q);
        }
        return root;
    }

    private static void inStack(Stack<TreeNode2> stack, TreeNode2 root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode2 tree = new TreeNode2("a");
        tree.left = new TreeNode2("b");
        tree.right = new TreeNode2("d");
        tree.left.left = new TreeNode2("c");
        tree.left.left.left = new TreeNode2("e");
        SerializeDeserializeTree serializeDeserializeTree = new SerializeDeserializeTree();
        String s = serializeDeserializeTree.serialize(tree);
        System.out.println(s);
        TreeNode2 treeNode2 = serializeDeserializeTree.deserialize(s);
        System.out.println(treeNode2.val);
        System.out.println(treeNode2.left.val);
        System.out.println(treeNode2.left.left.val);
        System.out.println(treeNode2.left.left.left.val);
        System.out.println(treeNode2.right.val);
//        Stack<TreeNode2> stack = new Stack<>();
//        inStack(stack, tree);
//        while (!stack.isEmpty()) {
//            TreeNode2 cur = stack.pop();
//            System.out.println(cur.val);
//            if (cur.right != null) {
//                inStack(stack, cur.right);
//            }
//        }
    }
}
