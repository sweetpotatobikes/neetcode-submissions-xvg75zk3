class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) return 0;
        int result = 0;
        int left = 0, right = heights.length - 1;
        
        while (left < right) {
            if (heights[left] < heights[right]) {
                result = Math.max(result, heights[left] * (right - left));
                left++;
            } else {
                result = Math.max(result, heights[right] * (right - left));
                right--;
            }
        }
        return result;
    }
}
