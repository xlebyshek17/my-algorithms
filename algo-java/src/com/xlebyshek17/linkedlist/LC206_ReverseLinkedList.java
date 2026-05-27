package com.xlebyshek17.linkedlist;

public class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;

            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
