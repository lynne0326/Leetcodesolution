package Lyft;

/**
 * Created by lingyanjiang on 16/12/5.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class SecondLargestBST {

    int count = 0;
    TreeNode res = null;

    public void traverse(TreeNode root, int k) {
        if (root.right != null) {
            traverse(root.right, k);
        }
        count++;
        if (count == k) {
            res = root;
            return;
        }
        if (root.left != null) {
            traverse(root.left, k);
        }
    }

    public void smalltraverse(TreeNode root, int k) {
        if (root.left != null) {
            smalltraverse(root.left, k);
        }
        count++;
        if (count == k) {
            res = root;
            return;
        }
        if (root.right != null) {
            smalltraverse(root.right, k);
        }
    }


    public static void main(String[] args) {
        SecondLargestBST slbst = new SecondLargestBST();
        TreeNode root = new TreeNode(8);
        TreeNode copy = root;
        root.right = new TreeNode(10);
        root = root.right;
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(13);
        TreeNode copy2 = copy;
        copy2.left = new TreeNode(3);
        copy2 = copy2.left;
        copy2.left = new TreeNode(1);
        copy2.right = new TreeNode(6);
        copy2.right.left = new TreeNode(4);
        copy2.right.right = new TreeNode(7);
//        slbst.traverse(copy, 1);
        slbst.smalltraverse(copy, 2);
        System.out.println(slbst.res.val);
    }
}
