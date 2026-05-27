package com.xlebyshek17.linkedlist;

//["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex",
// "deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]

//[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]

public class LC707_DesignedLinkedList {
    public static void main() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
    }
}

class MyLinkedList {
    private static class Node {
        int val;
        Node next;

        Node() {}
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = new Node();
        size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;

        if (size == 0 || index == 0) {
            addAtHead(val);
            return;
        }

        Node cur = head;
        Node newNode = new Node(val);
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) return;

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        if (index == size - 1) {
            cur.next = null;
        } else {
            cur.next = cur.next.next;
        }

        size--;
    }
}
