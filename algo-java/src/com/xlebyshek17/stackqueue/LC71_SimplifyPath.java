package com.xlebyshek17.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC71_SimplifyPath {
    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();


        for (String dir : dirs) {
            if ((stack.isEmpty() && "..".equals(dir)) || ".".equals(dir) || "".equals(dir)) {
                continue;
            }

            if ("..".equals(dir)) {
                stack.pollFirst();
            } else {
                stack.addFirst(dir);
            }
        }

        StringBuilder result = new StringBuilder();

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.pollLast());
        }

        return result.toString();
    }

    public static void main() {
        String path = "/home/user/Documents/../Pictures";
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            System.out.println(dir);
        }
    }
}
