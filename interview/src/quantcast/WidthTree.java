package quantcast;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 17/3/20.
 */
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class WidthTree {

    public int getWTreeWidth(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int curWidth = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) continue;
                curWidth++;
                q.add(cur.left);
                q.add(cur.right);
            }
            max = Math.max(max, curWidth);
        }
        return max;
    }
    public static void main(String[] args) {

    }
}
