class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = slow;

        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if (slow == fast) break;
        }

        fast = nums[0]; // reset
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
