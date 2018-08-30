package PoketGem;

import java.util.Stack;

/**
 * Created by lingyanjiang on 17/2/18.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int val) {
        this.val = val;
    }
}
public class InorderSuccessor {

    //1. if right substree of p is not empty, find the smallest node in right substree, that is the left most node in right branch
    //2. else find the closest ancestor whose left substree contains p, means we traceback the path to
    // parents that is larger than p,

    public TreeNode inorderSuccessorParentNode(TreeNode root, TreeNode p) {

        //默认node在树中
        if (p != null && p.right != null) {
            return findLeftmost(p.right);
        }
        TreeNode parentNode = root.parent;
        while (parentNode!= null && parentNode.val < p.val) {
            parentNode = parentNode.parent;
        }
        return parentNode;
    }

    private TreeNode findLeftmost(TreeNode right) {
        while (right.left != null) {
            right = right.left;
        }
        return right;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != p) {
            stack.push(root);
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        if (root.right != null) {
            //get leftmost child of right braunch
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
        //If no right child iterate paths to find node larger than p
        while (!stack.isEmpty() && stack.peek().val < p.val) {
            stack.pop();
        }

        return stack.isEmpty() ? null : stack.peek();

    }

    //如果不能比较value 如果没有value

    //1. 没有parent
    // if we are not allowed to compare the value of the node
    //O(n)
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean find = false;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (curr == p) {
                    find = true;
                } else if (find) {
                    return curr;
                }
                curr = curr.right;
            }
        }
        return null;
    }

    // O(h)
    //2.有parent
    //向上traceback to parent that is left child
    // 第一个leftchild
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode curr = p.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        TreeNode curr = p, parent = curr.parent;
        while (parent != null && parent.right == curr) {
            curr = parent;
            parent = curr.parent;
        }
        return parent;
    }
}
