import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lingyanjiang on 16/8/25.
 */
public class BinaryTreeLevelTraversal {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        if (root == null) {
            return result;
        }
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        boolean ascOrder = true;
        current.push(root);
        while (!current.isEmpty()) {
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            while (!current.isEmpty()) {
                TreeNode currentNode = current.pop();
                currentList.add(currentNode.val);
                if(ascOrder) {
                    if(currentNode.right != null) {
                        next.push(currentNode.right);
                    }
                    if(currentNode.left != null) {
                        next.push(currentNode.left);
                    }
                } else {
                    if(currentNode.left != null) {
                        next.push(currentNode.left);
                    }
                    if(currentNode.right != null) {
                        next.push(currentNode.right);
                    }
                }
            }
            stack.push(currentList);
            ascOrder = !ascOrder;
            Stack<TreeNode> tmp ;
            tmp = current;
            current = next;
            next = tmp;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        System.out.println(result);
        return result;
    }
    public static void main(String [] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        new BinaryTreeLevelTraversal().levelOrderBottom(root);
    }
}
