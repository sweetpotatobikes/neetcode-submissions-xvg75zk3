class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();
        if (s1Len > s2Len) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;

        int left = 0;
        int remaining = s1Len;

        for (int right = 0; right < s2Len; right++) {
            int c = s2.charAt(right) - 'a';
            if (freq[c] > 0) remaining--;
            freq[c]--;

            if (right - left + 1 == s1Len) {
                if (remaining == 0) return true;

                int temp = s2.charAt(left) - 'a';
                if (freq[temp] >= 0) remaining++;
                freq[temp]++;
                left++;
            }
        }
        return false;
    }
}
