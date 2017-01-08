import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lingyanjiang on 16/8/24.
 */
public class CompleteBinaryTree {
    public boolean isComplete(TreeNode root) {
        // Write your code here
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return true;
        }
        boolean flag = false;
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag) {
                if (node.left != null || node.right != null) {
                    return false;
                }
            }
            if(node.left == null && node.right != null) {
                return false;
            }
            if(node.left != null && node.right == null) {
                flag = true;
            }
            if(node.left == null || node.right == null) {
                flag = true;
            }
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }
}
