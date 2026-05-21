package com.xlebyshek17.slidingwindow;

public class LC209_MinimuSizeSubarraySize {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
