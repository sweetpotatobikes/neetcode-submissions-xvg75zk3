class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0, maxStart = 0;
        int left = 0, right = 0;

        int N = s.length();
        for (int i = 0; i < N; i++) {
            // odd case
            left = i;
            right = left;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    maxStart = left;
                }
                left--;
                right++;
            }

            // even case
            left = i;
            right = left + 1;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    maxStart = left;
                }
                left--;
                right++;
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }
}
