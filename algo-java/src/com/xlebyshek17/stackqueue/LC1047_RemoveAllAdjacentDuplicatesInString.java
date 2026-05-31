package com.xlebyshek17.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.getFirst()) {
                stack.pollFirst();
            } else {
                stack.addFirst(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollLast());
        }

        return result.toString();
    }
}
