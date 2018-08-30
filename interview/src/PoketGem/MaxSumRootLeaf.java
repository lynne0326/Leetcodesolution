package PoketGem;

/**
 * Created by lingyanjiang on 17/3/3.
 */
public class MaxSumRootLeaf {
    //V1 ----- root到leaf的 nlog(n), worst case是 balance tree, 每一个root都有n个leaf节点,至少n个root,
    //每次traverse到某个leaf的时间是高度o(h), worst case nlog(n)
    //the worst case is actually a fully-balanced tree where every leaf node matches the intended sum,
    // in which case the number of solutions is proportional to O(n),
    // but the actual copy to the array will be of O(log(n)) elements
    //So, My assessment is O(nlog(n))
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root, 0);
        return max;
    }

    private void helper(TreeNode node, int sum) {
        if (node == null) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            max = Math.max(max, sum);
        }
        helper(node.left, sum);
        helper(node.right, sum);
    }

    public int maxPathSumWithoutGlobal(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        return Math.max(maxPathSumWithoutGlobal(root.left), maxPathSumWithoutGlobal(root.right)) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(3);
        MaxSumRootLeaf instance = new MaxSumRootLeaf();
        instance.maxPathSum(root);
        System.out.println(instance.max);
        System.out.println(instance.maxPathSumWithoutGlobal(root));
        System.out.println(instance.getMaxTopDown(root));
    }

    //V2 Top down
    //Time Complexity should be O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
    public int getMaxTopDown(TreeNode root) {
        if (root == null) return 0;
        return Math.max(Math.max(dfs(root, 0), getMaxTopDown(root.left)),getMaxTopDown(root.right));
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        return Math.max(dfs(root.left, sum),dfs(root.right, sum)) + root.val;
    }

    //V3 Any node to Any node
//    int max = Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root) {
//        if (root == null) return 0;
//        dfs(root);
//        return max;
//    }
//
//    private int dfs(TreeNode root) {
//        if (root == null) return 0;
//        int left = dfs(root.left);
//        int right = dfs(root.right);
//        int curSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
//        max = Math.max(Math.max(curSum, left + right + root.val), max);
//        return curSum;
//    }
}
