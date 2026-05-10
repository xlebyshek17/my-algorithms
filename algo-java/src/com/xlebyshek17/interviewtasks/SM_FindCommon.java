package com.xlebyshek17.interviewtasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SM_FindCommon {
    public static int findCommon(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), i);
        }

        int maxSum = 0;
        int maxIndex = -1;
        for (int i = 0; i < list2.size(); i++) {
            int key = list2.get(i);
            if (map.containsKey(key)) {
                int curSum = map.get(key) + i;
                if (curSum > maxSum) {
                    maxSum = curSum;
                    maxIndex = i;
                }

            }
        }

        return maxIndex == -1 ? -1 : list2.get(maxIndex);
    }
}
