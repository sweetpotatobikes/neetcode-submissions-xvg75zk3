class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;
            if (map.containsKey(diff)) {
                int j = map.get(diff).getFirst();
                return new int[] {j,i};
            }
            map.putIfAbsent(curr, new LinkedList<>());
            map.get(curr).add(i);
        }
        return null;
    }
}
