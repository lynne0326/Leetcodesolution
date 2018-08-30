/**
 * Created by lingyanjiang on 17/1/11.
 */
public class RorateRightList {
    //先把头尾相接, 纪录len
    //从头走到cut的地方,cut掉
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tmp = head;
        int len = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        tmp.next = head;
        for (int i = len - k%len; i > 1; i--) {
            head = head.next;
        }
        tmp = head.next;
        head.next = null;
        return tmp;
    }
}
