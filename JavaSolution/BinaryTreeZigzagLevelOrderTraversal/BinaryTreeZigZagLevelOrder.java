import java.util.*;

/**
 * Created by lingyanjiang on 16/8/25.
 */


class ResultType {
    int depth;
    TreeNode node;
    public ResultType(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}

public class BinaryTreeZigZagLevelOrder {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    HashMap<Integer, ArrayList<Integer>> depthRecord = new HashMap<Integer, ArrayList<Integer>>();

    public ResultType helper(ResultType root) {
        Queue<ResultType> queue = new LinkedList<ResultType>();
        ArrayList<Integer> currentArray = new ArrayList<Integer>();
        int currentDepth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            ResultType current = queue.poll();
            if (currentDepth == current.depth) {
                currentArray.add(current.node.val);
            } else {
                depthRecord.put(currentDepth, currentArray);
                currentArray = new ArrayList<Integer>();
                currentArray.add(current.node.val);
                currentDepth = current.depth;
            }
            if (current.node.right != null) {
                queue.offer(new ResultType(current.depth + 1, current.node.right));
            }
            if (current.node.left != null) {
                queue.offer(new ResultType(current.depth + 1, current.node.left));
            }
        }
        depthRecord.put(currentDepth, currentArray);
        return root;
    }

    public void transForm() {
        for(Map.Entry<Integer, ArrayList<Integer>> entry:depthRecord.entrySet()) {
            if(entry.getKey() % 2 == 0) {
                result.add(entry.getValue());
            } else {
                ArrayList<Integer> reverse = new ArrayList<Integer>();
                for(int i = entry.getValue().size() - 1; i >= 0; i--) {
                    reverse.add(entry.getValue().get(i));
                }
                result.add(reverse);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        helper(new ResultType(1, root));
        transForm();
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        BinaryTreeZigZagLevelOrder order = new BinaryTreeZigZagLevelOrder();
        System.out.println(order.zigzagLevelOrder(root));
    }
}
