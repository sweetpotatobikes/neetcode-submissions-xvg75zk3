class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int n : nums) {
            q.offer(n);
            if (q.size() > k) q.poll();
        }
        return q.peek();
    }
}
