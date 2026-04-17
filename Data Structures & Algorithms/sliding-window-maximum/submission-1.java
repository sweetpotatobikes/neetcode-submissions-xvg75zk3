class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];

        Deque<Integer> queue = new LinkedList<>();
        int left = 0, right = 0;

        while (right < len) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[right]) {
                queue.removeLast();
            }

            while (!queue.isEmpty() && queue.getFirst() < left) {
                queue.removeFirst();
            }

            queue.addLast(right);
            if ((right + 1) >= k) {
                result[left] = nums[queue.getFirst()];
                left++;
            }
            right++;
        }
        return result;
    }
}
