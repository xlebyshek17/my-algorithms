package com.xlebyshek17.twopointers;

public class LC977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int i = len - 1;

        int[] result = new int[len];

        while (l < r) {
            int numL = nums[l] * nums[l];
            int numR = nums[r] * nums[r];

            if (numL > numR) {
                result[i] = numL;
                l++;
            } else {
                result[i] = numR;
                r--;
            }

            i--;
        }

        result[0] = nums[l] * nums[l];

        return result;
    }
}
