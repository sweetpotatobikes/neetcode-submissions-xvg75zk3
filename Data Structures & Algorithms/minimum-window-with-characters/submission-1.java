class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int resultStart = 0;
        int resultLength = Integer.MAX_VALUE;

        int left = 0;
        int foundLetters = 0;

        int[] freq = new int[122];
        for (char c : t.toCharArray()) freq[c - 'A']++;

        for (int right = 0; right < s.length(); right++) {
            char char_at_right = s.charAt(right);

            if (freq[char_at_right - 'A'] > 0) foundLetters++;
            freq[char_at_right - 'A']--;

            while (foundLetters == t.length()) {
                int length = right - left + 1;

                if (length < resultLength) {
                    resultLength = length;
                    resultStart = left;
                }

                char char_at_left = s.charAt(left);
                freq[char_at_left - 'A']++;
                if (freq[char_at_left - 'A'] > 0) foundLetters--;
                left++;
            }
        }

        return (resultLength == Integer.MAX_VALUE) ? "" : s.substring(resultStart, resultStart + resultLength);
    }
}
