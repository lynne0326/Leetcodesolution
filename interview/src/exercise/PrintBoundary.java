package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/3/25.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PrintBoundary {
    /**
     * Definition for a binary tree node.

     */
    private void traverseLeft(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left != null) {
            res.add(root.val);
            traverseLeft(root.left, res);
        } else if (root.right != null) {
            res.add(root.val);
            traverseLeft(root.right, res);
        }
    }

    private void traverseRight(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.right != null) {
            traverseRight(root.right, res);
            res.add(root.val);
        } else if (root.left != null) {
            traverseRight(root.left, res);
            res.add(root.val);
        }
    }

    private void traverseLeaf(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traverseLeaf(root.left, res);
        if (root.left == null && root.right == null) res.add(root.val);
        traverseLeaf(root.right, res);
    }


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        traverseLeft(root.left, res);
        traverseLeaf(root.left, res);
        traverseLeaf(root.right, res);
        traverseRight(root.right, res);
        return res;
    }
}
