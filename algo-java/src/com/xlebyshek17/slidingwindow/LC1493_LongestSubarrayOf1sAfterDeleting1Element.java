package com.xlebyshek17.slidingwindow;

public class LC1493_LongestSubarrayOf1sAfterDeleting1Element {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int window_state = 0;
        int max = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                window_state++;

                if (window_state > 1) {
                    while (nums[start] != 0) start++;
                    window_state--;
                    start++;
                }
            }

            max = Math.max(max, end - start);
        }

        return max;
    }
}
