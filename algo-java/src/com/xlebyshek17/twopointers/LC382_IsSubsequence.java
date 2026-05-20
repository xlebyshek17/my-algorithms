package com.xlebyshek17.twopointers;

public class LC382_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int first = 0;
        int second = 0;

        while(first < t.length() && second < s.length()) {
            if (t.charAt(first) == s.charAt(second)) {
                second++;
            }
            first++;
        }

        return second == s.length();
    }
}
