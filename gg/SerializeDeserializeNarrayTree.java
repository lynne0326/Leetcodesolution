import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lingyanjiang on 18/8/12.
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class SerializeDeserializeNarrayTree {

    //方法一: 纯string dfs
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(root.val);
        for (Node child: root.children) {
            sb.append(serialize(child));
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Node root = null;
        if (data.length() == 0) return root;
        int cnt = 0;
        int start = -1;
        int val = 0;
        boolean found = false;
        List<Node> children = new ArrayList<>();
        for (int i = 1; i < data.length(); i++) {
            if (!found && Character.isDigit(data.charAt(i))) {
                val = val * 10 + (data.charAt(i) - '0');
            }
            if (data.charAt(i) == '[') {
                found = true;
                cnt++;
                if (cnt == 1) {
                    start = i;
                }
            }
            if (data.charAt(i) == ']') {
                cnt--;
                if (cnt == 0) {
                    children.add(deserialize(data.substring(start, i + 1)));
                }
            }
        }
        root = new Node(val, children);
        return root;
    }


    //方法二: preorder + encode root.val + children.size(), + queue
    // Encodes a tree to a single string.
    public String serialize2(Node root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(",");
        for (Node child: root.children) {
            sb.append(serialize(child)).append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize2(String data) {
        String[] splited = data.split(",");
        Queue<String> q = new LinkedList<>();
        for (String s: splited) {
            if (s.trim().length() == 0) continue;
            q.offer(s.trim());
        }
        return helper(q);
    }

    private Node helper(Queue<String> q) {
        if (q.isEmpty()) return null;
        int val = Integer.parseInt(q.poll());
        int cnt = Integer.parseInt(q.poll());
        Node root = new Node(val, new ArrayList<>());
        for (int i = 0; i < cnt; i++) {
            root.children.add(helper(q));
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeNarrayTree serializeDeserializeNarrayTree = new SerializeDeserializeNarrayTree();
        Node t5 = new Node(5, new ArrayList<>());
        Node t6 = new Node(6, new ArrayList<>());
        Node t3 = new Node(3, new ArrayList<>());
        t3.children.add(t5);
        t3.children.add(t6);
        Node t2 = new Node(2, new ArrayList<>());
        Node t4 = new Node(4, new ArrayList<>());

        Node root = new Node(1, new ArrayList<>());
        root.children.add(t2);
        root.children.add(t3);
        root.children.add(t4);


        String res = serializeDeserializeNarrayTree.serialize(root);
        System.out.println(res);

        Node tree = serializeDeserializeNarrayTree.deserialize(res);
        System.out.println();
    }
}
