class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currMax = 1, currMin = 1;
        int prevMax = 1, prevMin = 1;

        for (int num : nums) {
            prevMax = currMax;
            prevMin = currMin;

            currMax = Math.max(num, Math.max(num * prevMax, num * prevMin));
            currMin = Math.min(num, Math.min(num * prevMax, num * prevMin));

            result = Math.max(result, currMax);
        }

        return result;
    }
}
