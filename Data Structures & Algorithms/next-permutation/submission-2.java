class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = this.findPivot(nums);

        if (pivot != -1) {
            int next = findNextGreater(nums, pivot);
            this.swap(nums, pivot, next);
        }
        this.reverse(nums, pivot + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private int findPivot(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) return i;
        }
        return -1;
    }

    private int findNextGreater(int[] nums, int pivot) {
        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) return i;
        }
        return pivot;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}