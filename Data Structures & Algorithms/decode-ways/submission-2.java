class Solution {
    public int numDecodings(String s) {
        int two_steps_back_count = 1; // empty string
        int one_step_back_count = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            int count = 0;
            if (curr != '0') count += one_step_back_count;
            if ((prev == '1') || (prev == '2' && curr <= '6')) count += two_steps_back_count;

            two_steps_back_count = one_step_back_count;
            one_step_back_count = count;
        }
        return one_step_back_count;
    }
}
