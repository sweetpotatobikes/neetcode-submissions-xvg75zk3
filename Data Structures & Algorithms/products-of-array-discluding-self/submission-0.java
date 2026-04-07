class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int temp = 1;
        Arrays.fill(result, temp);

        for (int i = 0; i < len; i++) {
            result[i] *= temp;
            temp *= nums[i];
        }
        
        temp = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        return result;
    }
}  
