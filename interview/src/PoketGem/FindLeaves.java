package PoketGem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/21.
 */
public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private int dfs(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        //nodes with same height goes to the same level result
        int depth = Math.max(dfs(node.left, res), dfs(node.right, res)) + 1;
        if (res.size() <= depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);
        return depth;
    }

}
