package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lingyanjiang on 17/2/20.
 */
public class TreeListAfterRemoval {
    Set<TreeNode> nodes = new HashSet<>();

    private boolean shoudRemove(TreeNode cur) {
        return nodes.contains(cur);
    }

    public List<TreeNode> solution(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(null, root, res);
        return res;
    }

    private void helper(TreeNode parent, TreeNode cur, List<TreeNode> res) {
        if (cur == null) return;
        if (shoudRemove(cur)) {
            if (parent.left == cur) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            helper(null, cur.left, res);
            helper(null, cur.right, res);
        } else {
            if (parent == null) {
                res.add(cur);
            }
            helper(cur, cur.left, res);
            helper(cur, cur.right, res);
        }
    }
}
