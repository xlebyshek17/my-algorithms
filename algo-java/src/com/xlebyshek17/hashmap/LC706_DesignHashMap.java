package com.xlebyshek17.hashmap;

public class LC706_DesignHashMap {
    static class MyHashMap {
        static class Bucket {
            static class Node {
                int key;
                int value;

                Node next;

                Node() {}
                Node(int key, int value) {
                    this.key = key;
                    this.value = value;
                }
            }
            Node head;
            int size;

            void addNode(int key, int value) {
                if (head == null) {
                    head = new Node(key, value);
                    size++;
                    return;
                }

                Node cur = head;

                while (cur.next != null) {
                    if (cur.key == key) {
                        cur.value = value;
                        return;
                    }
                    cur = cur.next;
                }
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur.next = new Node(key, value);

                size++;
            }

            void removeNode(int key) {
                if (head == null) return;

                if (head.key == key) {
                    head = head.next;
                    size--;
                    return;
                }
                Node cur = head;

                while (cur.next != null) {
                    if (cur.next.key == key) {
                        cur.next = cur.next.next;
                        size--;
                        return;
                    }
                    cur = cur.next;
                }
            }

            int getNode(int key) {
                Node cur = head;

                while (cur != null) {
                    if (cur.key == key) {
                        return cur.value;
                    }
                    cur = cur.next;
                }

                return -1;
            }
        }

        int sizeMap = 128;
        Bucket[] buckets;

        public MyHashMap() {
            buckets = new Bucket[sizeMap];
            for (int i = 0; i < sizeMap; i++) {
                buckets[i] = new Bucket();
            }
        }

        private int hashCode(int key) {
            return key % sizeMap;
        }

        public void put(int key, int value) {
            buckets[hashCode(key)].addNode(key, value);
        }

        public int get(int key) {
            return buckets[hashCode(key)].getNode(key);
        }

        public void remove(int key) {
            buckets[hashCode(key)].removeNode(key);
        }
    }

    static void main() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.get(1);
        myHashMap.get(3);
        myHashMap.put(2, 1);
        myHashMap.get(2);
        myHashMap.remove(2);
        myHashMap.get(2);
    }
}
