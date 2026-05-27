package com.xlebyshek17.linkedlist;

public class LC2095_DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;

        while (fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        cur.next = slow.next;

        return head;
    }
}
