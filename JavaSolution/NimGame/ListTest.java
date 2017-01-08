/**
 * Created by lingyanjiang on 16/8/27.
 */
public class ListTest {
    static void print(ListNode head) {
        for (ListNode node = head; node != null;node = node.next) {
            System.out.println(node.val);
            System.out.println("->");
        }
        System.out.println("null");
    }

    public static void main() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode head = node1;

        node1.next = node2;
        node2.next = node3;
        print(head);
        node1 = node2;
        print(head);
    }
}
