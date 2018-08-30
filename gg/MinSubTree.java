/**
 * Created by lingyanjiang on 18/7/24.
 */
public class MinSubTree {
    // method 1: traverse, dc
//    TreeNode maxNode;
//    int maxSum = Integer.MAX_VALUE;
//
//    public TreeNode minSubTree(TreeNode root) {
//        if (root == null) return root;
//        helper(root);
//        return maxNode;
//    }
//
//    private int helper(TreeNode node) {
//        if (node == null) return 0;
//        int sum = helper(node.left) + helper(node.right) + node.val;
//        if (sum <= maxSum) {
//            maxSum = sum;
//            maxNode = node;
//        }
//        return sum;
//    }

    class ResultType {
        TreeNode node;
        int sum;
        int min;
        public ResultType(TreeNode node, int sum, int min) {
            this.node = node;
            this.sum = sum;
            this.min = min;
        }
    }

    public TreeNode minSubTree(TreeNode root) {
        if (root == null) return root;
        return helper(root).node;
    }

    private ResultType helper(TreeNode node) {
        if (node == null) return new ResultType(node, 0, Integer.MAX_VALUE);
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        int sum = left.sum + right.sum + node.val;
        ResultType res = new ResultType(node, sum, sum);
        if (left.min <= res.min) {
            res.min = left.min;
            res.node = left.node;
        }
        if (right.min <= res.min) {
            res.min = right.min;
            res.node = right.node;
        }
        return res;
    }
}
