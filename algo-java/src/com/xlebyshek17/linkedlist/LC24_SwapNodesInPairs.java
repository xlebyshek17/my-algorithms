package com.xlebyshek17.linkedlist;

public class LC24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;


        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;

            cur = first;
        }

        return dummy.next;
    }
}
