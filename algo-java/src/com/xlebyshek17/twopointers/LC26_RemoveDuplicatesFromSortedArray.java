package com.xlebyshek17.twopointers;

public class LC26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 0;
        int len = nums.length;
        int count = 0;

        while (second < len) {
            nums[first] = nums[second];
            count++;

            while (second < len && nums[first] == nums[second]) {
                second++;
            }
            first++;
        }

        return count;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 1) return 1;

        int first = 0;
        int second = 0;
        int len = nums.length;
        int count = 1;

        while (second < len) {
            if (nums[first] == nums[second]) {
                second++;
            } else {
                count++;
                nums[first + 1] = nums[second];
                first++;
                second++;
            }
        }

        return count;
    }

    public int removeDuplicates3(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }
}
