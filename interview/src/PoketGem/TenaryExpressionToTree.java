package PoketGem;

import java.util.Stack;

/**
 * Created by lingyanjiang on 17/2/27.
 */


public class TenaryExpressionToTree {


    class TreeNode<T> {
        T val;
        TreeNode left;
        TreeNode right;
        public TreeNode(T val) {
            this.val = val;
        }
    }

    // Space Complexity: O(1)
//    time complexity O(nlogn), space O(1).because need to find question mark and colon,
//    用递归所以每次长度都是logn, 对于每个长度，n去寻找?和:
    //Each recursive length is logn, and each time we need to search the comma and question marks which is O(n)
    //So the total is O(nlogn)
    public TreeNode convertToTree(String s) {
        if (s == null || s.length() == 0) return null;
        int i = 0, count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '?') {
                count++;
            } else if (s.charAt(i) == ':') {
                count--;
                if (count == 0) break;
            }
            i++;
        }
        TreeNode root = new TreeNode(s.charAt(0));
        if (s.indexOf(":") == -1) return root;
        root.left = convertToTree(s.substring(2, i));
        root.right = convertToTree(s.substring(i+1));
        return root;
    }

//Stack的做法 O(n) space, O(n) time
//    When I see a question mark '?', next character is my left child, so add to my left and go left.
//
//    If I see comma':', then:
//     如果见到comma,就回溯到parent, 看parent如果没有右孩子,那么下一个character就是右孩子, 如果parent有右孩子,
//      就不停 parent = parent.parent, 回溯到parent的parent
//    Go to my parent
//    If right is not null and parent is not not null, keep going to my parent
//    My right child is empty. Add right. Go to right.
//            Note: You will never go back to the root if it has a right child.
    public TreeNode convert2(char[] expr) {
        TreeNode root = new TreeNode(expr[0]);
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 1; i < expr.length; i += 2) {
            if (expr[i] == '?') {
                //The left child is the character right next to it
                curr.left = new TreeNode(expr[i + 1]);
                //We push current node to stack
                stack.push(curr);
                //and keep going its left
                curr = curr.left;
            } else if (expr[i] == ':') {
                //So now the next value is the right child of the peek element in stack, now which is b
                curr = stack.pop();
                //We set the right child to be next character,
                curr.right = new TreeNode(expr[i + 1]);
                //and we update current node to be the right child
                curr = curr.right;
            }
        }
        return root;
    }

    private static void inStack(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TenaryExpressionToTree t = new TenaryExpressionToTree();
        TreeNode tree = t.convertToTree("a?b?c:d?e:f:g?h:i");
//        TreeNode tree = t.convert2("a?b?c:d?e:f:g?h:i".toCharArray());
        Stack<TreeNode> stack = new Stack<>();
        inStack(stack, tree);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                inStack(stack, cur.right);
            }
        }
    }
}
