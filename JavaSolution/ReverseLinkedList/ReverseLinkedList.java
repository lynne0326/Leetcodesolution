/**
 * Created by lingyanjiang on 16/6/11.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode node = this.reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
