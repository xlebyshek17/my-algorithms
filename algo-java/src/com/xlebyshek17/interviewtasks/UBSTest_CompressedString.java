package com.xlebyshek17.interviewtasks;

import java.util.ArrayList;
import java.util.List;

public class UBSTest_CompressedString {
    public static List<String> solve(String s) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int count = 1;

            while (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            output.add(s.charAt(i) + String.valueOf(count));
        }

        return output;
    }
}
