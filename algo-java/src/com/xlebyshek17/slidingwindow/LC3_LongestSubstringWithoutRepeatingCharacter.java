package com.xlebyshek17.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LC3_LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int window_size = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        for (int end = 0; end < s.length(); end++) {
            set.add(s.charAt(end));
            window_size = end - start + 1;
            while (set.size() < window_size) {
                if (s.charAt(start) != s.charAt(end))
                    set.remove(s.charAt(start));

                start++;
                window_size--;
            }

            max = Math.max(max, window_size);
        }

        return max;
    }
}
