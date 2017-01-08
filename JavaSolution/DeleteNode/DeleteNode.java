/**
 * Created by lingyanjiang on 16/6/6.
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

class ListNode {
       int val;
         ListNode next;
         ListNode(int x) { val = x; }
}
