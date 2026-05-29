package com.xlebyshek17.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LC141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            cur = cur.next;
        }

        return false;
    }
}
