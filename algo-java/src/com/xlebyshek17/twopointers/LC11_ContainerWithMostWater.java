package com.xlebyshek17.twopointers;

public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int heightL = height[l];
            int heightR = height[r];

            maxArea = Math.max(maxArea, (r - l) * Math.min(heightL, heightR));

            if (heightL < heightR) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
