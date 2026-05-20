package com.xlebyshek17.twopointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC844_BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty())
                    stack1.pop();
            }
            else {
                stack1.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stack2.isEmpty())
                    stack2.pop();
            }
            else {
                stack2.push(t.charAt(i));
            }
        }

        if (stack1.size() != stack2.size()) return false;

        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop())
                return false;
        }

        return true;
    }

    public static void main() {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }
}
