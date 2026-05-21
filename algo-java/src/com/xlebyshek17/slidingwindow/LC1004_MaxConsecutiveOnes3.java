package com.xlebyshek17.slidingwindow;

public class LC1004_MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int window_state = 0; // count of zeroes
        int max = 0;

        for (int end = 0; end < nums.length; end++) {

            if (nums[end] == 0) {
                window_state++;
                if (window_state > k) {
                    while (nums[start] != 0) start++;
                    window_state--;
                    start++;
                }
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
