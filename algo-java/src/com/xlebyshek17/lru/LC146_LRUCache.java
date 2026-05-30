package com.xlebyshek17.lru;

import java.util.HashMap;
import java.util.Map;

public class LC146_LRUCache {
    static class LRUCache {
        static class Node {
            int key;
            int value;

            Node next;
            Node prev;

            Node() {}
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, Node> map;
        Node head;
        Node tail;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node();
            tail = new Node();

            head.next = tail;
            tail.prev = head;
        }

        private void addFirst(Node cur) {
            cur.next = head.next;
            cur.prev = head;
            head.next.prev = cur;
            head.next = cur;
        }

        private void removeNode(Node cur) {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }

        private Node getNode(int key) {
            if (map.containsKey(key)) {
                Node cur = map.get(key);

                removeNode(cur);

                addFirst(cur);

                return cur;
            }

            return null;
        }

        public int get(int key) {
            Node found = getNode(key);

            if (found != null) {
                return found.value;
            }

            return -1;
        }

        public void put(int key, int value) {
            Node found = getNode(key);

            if (found != null) {
                found.value = value;
                return;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);

            addFirst(newNode);

            size++;

            if (size > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                size--;
            }
        }
    }
}
