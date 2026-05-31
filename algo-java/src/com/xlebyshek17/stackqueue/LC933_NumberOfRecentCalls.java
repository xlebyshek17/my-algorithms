package com.xlebyshek17.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC933_NumberOfRecentCalls {
    class RecentCounter {
        private Deque<Integer> requests;

        public RecentCounter() {
            requests = new ArrayDeque<>();
        }

        public int ping(int t) {
            requests.addLast(t);
            int lowerBound = t - 3000;

            while (requests.peekFirst() < lowerBound) {
                requests.pollFirst();
            }

            return requests.size();
        }
    }
}
