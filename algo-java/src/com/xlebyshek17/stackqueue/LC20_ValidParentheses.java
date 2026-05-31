package com.xlebyshek17.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC20_ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addFirst(')');
            } else if (s.charAt(i) == '{') {
                stack.addFirst('}');
            } else if (s.charAt(i) == '[') {
                stack.addFirst(']');
            } else {
                if (stack.isEmpty() || s.charAt(i) != stack.pollFirst()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
