class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;
            if (map.containsKey(diff)) {
                int j = map.get(diff);
                return new int[] {j,i};
            }
            map.put(curr, i);
        }
        return null;
    }
}
