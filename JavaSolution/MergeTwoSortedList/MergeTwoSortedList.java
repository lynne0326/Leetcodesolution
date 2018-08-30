/**
 * Created by lingyanjiang on 17/1/11.
 */
public class MergeTwoSortedList {
    //recursive 解法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur;
        if (l1.val < l2.val) {
            cur = l1;
            cur.next = mergeTwoLists(l1.next, l2);
        }
        else {
            cur = l2;
            cur.next = mergeTwoLists(l1, l2.next);
        }
        return cur;
    }

    //一般解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null) {
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
