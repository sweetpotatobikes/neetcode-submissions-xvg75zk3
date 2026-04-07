class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        
        for (char i = 'A'; i <= 'Z'; i++) {
            int left = 0, right = 0, replaced = 0;
            while (right < s.length()) {
                if (s.charAt(right) == i) right++;
                else if (replaced < k) {
                    right++;
                    replaced++;
                } else if (s.charAt(left) == i) left++; //shrink window
                else {
                    left++;
                    replaced--;
                }
                result = Math.max(result, right - left);
            }
        }

        return result;
    }
}
