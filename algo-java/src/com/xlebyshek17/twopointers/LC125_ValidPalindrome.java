package com.xlebyshek17.twopointers;

public class LC125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < s.length() && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (l >= s.length() || r < 0) return true;

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    static void main() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
