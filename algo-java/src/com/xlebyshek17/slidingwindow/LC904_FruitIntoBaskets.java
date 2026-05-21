package com.xlebyshek17.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC904_FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int start = 0;
        int max = 0;
        Map<Integer, Integer> trees = new HashMap<>();

        for (int end = 0; end < fruits.length; end++) {

            trees.put(fruits[end], trees.getOrDefault(fruits[end], 0) + 1);

            while (trees.size() > 2) {
                int value = trees.get(fruits[start]);

                if (value == 1) {
                    trees.remove(fruits[start]);
                } else {
                    trees.put(fruits[start], value - 1);
                }

                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
