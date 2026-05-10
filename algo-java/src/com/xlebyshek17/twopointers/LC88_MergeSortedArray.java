package com.xlebyshek17.twopointers;

public class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1;
        int k = n - 1;
        int len = n + m - 1;

        for (int i = len; i >= 0; i--) {
            if (j < 0) {
                while (k >= 0) {
                    nums1[i] = nums2[k];
                    i--;
                    k--;
                }
                break;
            }

            if (k < 0) {
                while (j >= 0) {
                    nums1[i] = nums1[j];
                    i--;
                    j--;
                }
                break;
            }

            if (nums1[j] > nums2[k]) {
                nums1[i] = nums1[j];
                j--;
            } else {
                nums1[i] = nums2[k];
                k--;
            }
        }
    }
}
