package quantcast;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 17/3/20.
 */
public class AvgDepthTree {

    int depthTotal = 0;
    int count = 0;

    public int avgDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return depthTotal/count;
    }

    private void dfs(TreeNode root, int idx) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            count++;
            depthTotal += idx;
        }
        dfs(root.left, idx + 1);
        dfs(root.right, idx + 1);
    }


    public int avgDepthTraverse(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int curDepth = 1;
        int count = 0;
        int depthTotal = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;
                if (cur.left == null && cur.right == null) {
                    depthTotal += curDepth;
                    count++;
                }
                q.offer(cur.left);
                q.offer(cur.right);
            }
            curDepth++;
        }

        return depthTotal/count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int res = new AvgDepthTree().avgDepth(root);
        System.out.println(res);
    }
}
