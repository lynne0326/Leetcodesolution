package Lyft;

import java.util.Stack;

/**
 * Created by lingyanjiang on 16/12/5.
 */
class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
    }
}

class BSTIterator {
    Node root;
    Stack<Node> stack = new Stack<>();

    BSTIterator(Node root) {
        this.root = root;
        inStack(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node cur = stack.peek();
        stack.pop();
        inStack(cur.right);
        return cur.val;
    }

    public void inStack(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}


public class BinarySearchTree {
    Node root = null;

    void insert(int num) {
        if (root == null) {
            root = new Node(num);
            return;
        }
        Node parent = null;
        Node fakeRoot = root;
        while (fakeRoot != null) {
            parent = fakeRoot;
            if (num >= fakeRoot.val) {
                fakeRoot = fakeRoot.right;
            } else {
                fakeRoot = fakeRoot.left;
            }
        }
        if (num >= parent.val) {
            parent.right = new Node(num);
        } else {
            parent.left = new Node(num);
        }
    }

    Node search(int num) {
        Node cur = root;
        while (cur != null) {
            if (num == cur.val) {
                return cur;
            } else if (num < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }

    int size() {
        return sizeHelper(root);
    }

    private int sizeHelper(Node cur) {
        if (cur == null) {
            return 0;
        }
        return sizeHelper(cur.left) + sizeHelper(cur.right) + 1;
    }

    int height() {
        return findDepth(root);
    }

    private int findDepth(Node cur) {
        if (cur == null) {
            return 0;
        }
        return Math.max(findDepth(cur.left)+1, findDepth(cur.right)+1);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        System.out.println(bst.size());
        System.out.println(bst.height());
        BSTIterator bstIterator = new BSTIterator(bst.root);
//        while (bstIterator.hasNext()) {
//            System.out.println(bstIterator.next());
//        }
    }

}
