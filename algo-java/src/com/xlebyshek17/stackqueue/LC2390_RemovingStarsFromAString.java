package com.xlebyshek17.stackqueue;

public class LC2390_RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(s.charAt(i));
            }
        }

        return stack.toString();
    }
}
