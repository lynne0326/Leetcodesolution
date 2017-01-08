package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lingyanjiang on 16/12/21.
 */


class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class CopyRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode fakeHead = dummy;
        while (head != null) {
            if (map.containsKey(head)) {
                fakeHead.next = map.get(head);
            } else {
                fakeHead.next = new RandomListNode(head.label);
                map.put(head, fakeHead.next);
            }
            //deal with random
            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    fakeHead.next.random = map.get(head.random);
                } else {
                    fakeHead.next.random = new RandomListNode(head.random.label);
                    map.put(head.random, fakeHead.next.random);
                }
            }
            //move on
            head = head.next;
            fakeHead = fakeHead.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode fakeHead = head;
        //insert a copy node behind
        while (fakeHead != null) {
            RandomListNode tmp = new RandomListNode(fakeHead.label);
            tmp.next = fakeHead.next;
            tmp.random = fakeHead.random;
            fakeHead.next = tmp;
            fakeHead = fakeHead.next.next;
        }
        RandomListNode fakeHead2 = head;
        while (fakeHead2 != null) {
            if (fakeHead2.random != null) {
                fakeHead2.next.random = fakeHead2.random.next;
            }
            fakeHead2 = fakeHead2.next.next;
        }

        RandomListNode dummy = new RandomListNode(0);
        RandomListNode res = dummy;
        dummy.next = head;
        while (head != null) {
            res.next = head.next;
            head = head.next.next;
            res = res.next;
        }
        return dummy.next;
    }
}
