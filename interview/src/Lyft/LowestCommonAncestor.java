package Lyft;

/**
 * Created by lingyanjiang on 16/12/5.
 */
public class LowestCommonAncestor {

    //o(n),
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        //Both on left side
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        //Both on right side
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    //f(n)=2*f(n-1)=2*2*f(n-2)=2^(logn), so time=O(n).
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}
