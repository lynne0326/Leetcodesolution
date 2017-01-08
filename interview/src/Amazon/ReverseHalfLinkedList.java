package Amazon;

/**
 * Created by lingyanjiang on 16/12/21.
 */
public class ReverseHalfLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode next = slow.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = prev;
            prev = next;
            next = tmp;
        }
        slow.next = prev;
        return dummy;
    }

    public static ListNode reverseSecondHalfList(ListNode head) {
        if (head == null || head.next == null)      return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(reverse(head));
        System.out.println(reverseSecondHalfList(head));
    }

}
