package com.xlebyshek17.slidingwindow;

public class LC643_MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int curSum = 0;
        int maxSum = 0;

        for (; right < k; right++) {
            curSum += nums[right];
        }

        maxSum = curSum;

        for (; right < nums.length; right++) {
            curSum = curSum - nums[left] + nums[right];
            maxSum = Math.max(maxSum, curSum);
            left++;
        }

        return maxSum / (double)k;
    }

    public double findMaxAverage2(int[] nums, int k) {
        int begin = 0;
        int windowState = 0;
        double result = -Double.MAX_VALUE;;

        for (int end = 0; end < nums.length; end++) {
            windowState += nums[end];

            if (end - begin + 1 == k) {
                result = Math.max(result, windowState);
                windowState -= nums[begin];
                begin++;
            }
        }

        return result / k;
    }
}
