package google;

/**
 * Created by lingyanjiang on 17/2/9.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class MaxSubtreeRange {
    class ResultType {
        int subSize;
        boolean isInRange;
        public ResultType(int subSize, boolean isInRange) {
            this.subSize = subSize;
            this.isInRange = isInRange;
        }
    }

    int max = 0;

    public int solution(int A, int B, TreeNode root) {
        helper(root, A, B);
        return max;
    }

    private ResultType helper(TreeNode root, int A, int B) {
        if (root == null) return new ResultType(0, true);
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        int subSize = 0;
        boolean isInRange = (root.val >= A && root.val <= B);
        if (left.isInRange && right.isInRange) {
            subSize += left.subSize + right.subSize;
            if (isInRange) {
                subSize += 1;
                max = Math.max(subSize, max);
            }
        }
        return new ResultType(subSize, left.isInRange && right.isInRange && isInRange);
    }

    public static void main(String[] args) {
        MaxSubtreeRange maxSubtreeRange = new MaxSubtreeRange();
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(13);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(31);
        maxSubtreeRange.solution(10, 30, root);
        System.out.println(maxSubtreeRange.max);
    }
}
