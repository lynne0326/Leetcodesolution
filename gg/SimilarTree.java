/**
 * 可以swap children叫similar tree
 * 我猜测就是在考same tree换一个考法
 */
public class SimilarTree {
    public boolean similarTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 != null || root2 != null) return false;
        if (root1.val != root2.val) return false;
        return (similarTree(root1.left, root2.right) && similarTree(root1.right, root2.left)) ||
                (similarTree(root1.right, root2.right) && similarTree(root1.left, root2.left));
    }
}
