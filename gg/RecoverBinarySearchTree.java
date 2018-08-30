import java.util.Stack;

/**
 * Created by lingyanjiang on 18/8/29.
 */
public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    // 递归
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);

        if(prev != null && root.val <= prev.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        traverse(root.right);
    }


    //stack 的方法
    public void recoverTreeii(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(prev != null && cur.val <= prev.val) {
                    if(first == null) {
                        first = prev;
                    }
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
