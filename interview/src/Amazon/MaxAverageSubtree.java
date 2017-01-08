package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lingyanjiang on 16/12/22.
 */
class TreeNode {
    int months;
    List<TreeNode> subs;
    public TreeNode(int months, List<TreeNode> subs) {
        this.months = months;
        this.subs = subs;
    }
    public TreeNode(int months) {
        this.months = months;
        this.subs = new ArrayList<>();
    }
}

public class MaxAverageSubtree {
    //最土的办法,每次都bfs去遍历找一次
    public TreeNode maxAverageSubtee(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double max = 0;
        TreeNode node = null;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            double average = findAverage(cur);
            if (average >= max) {
                max = average;
                node = cur;
            }
            for(TreeNode sub: cur.subs) {
                queue.add(sub);
            }
        }
        System.out.println(max);
        return node;
    }

    private double findAverage(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        int sum = 0;
        //注意这里如果节点没有sub,还是要count和sum+的,但是返回average是0
        if (node.subs == null || node.subs.size() == 0) {
            return 0;
        }
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            for(TreeNode sub: cur.subs) {
                q.add(sub);
            }
            sum += cur.months;
            count++;
        }
        return (double) sum / count;
    }


    //method2 dfs
    class ResultType{
        int val;
        int count;
        TreeNode maxNode;
        double res;
        public ResultType(int val, int count, double curMax, TreeNode curMaxNode) {
            this.val = val;
            this.count = count;
            this.maxNode = curMaxNode;
            this.res = curMax;
        }
    }

    private ResultType dfs(TreeNode node) {
        if (node == null) {
            return new ResultType(0, 0, 0, node);
        }
        if (node.subs == null || node.subs.size() == 0) {
            return new ResultType(node.months, 1, 0 , node);
        }
        int count = 1;
        int months = node.months;
        double curMax = 0;
        TreeNode curMaxNode = null;
        for (TreeNode child: node.subs) {
            ResultType resultType = dfs(child);
            count += resultType.count;
            months += resultType.val;
            TreeNode tmpMax = resultType.maxNode;
            double tmpMaxDouble = resultType.res;
            if (tmpMaxDouble > curMax) {
                curMax = tmpMaxDouble;
                curMaxNode = tmpMax;
            }
        }
        if ((double)months/count > curMax) {
            curMax = (double) months/count;
            curMaxNode = node;
        }
        return new ResultType(months, count, curMax, curMaxNode);
    }

    private TreeNode findAverage2(TreeNode node) {
        ResultType type = dfs(node);
        System.out.println(type.res);
        return type.maxNode;
    }

    public static void main(String[] args) {
        MaxAverageSubtree mas = new MaxAverageSubtree();
        TreeNode root = new TreeNode(1);
        root.subs = new ArrayList<>();
        root.subs.add(new TreeNode(2));
        root.subs.add(new TreeNode(3));
        root.subs.add(new TreeNode(4));
        for (TreeNode subs: root.subs) {
            subs.subs.add(new TreeNode(5));
            subs.subs.add(new TreeNode(5));
        }
        TreeNode node = mas.findAverage2(root);
        System.out.println(node.months);
    }
}
