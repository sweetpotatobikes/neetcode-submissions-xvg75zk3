class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for (int i = buckets.length - 1; i > 0; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket != null && bucket.size() > 0 && resultIndex < k) {
                for (int j = 0; j < bucket.size(); j++) {
                    result[resultIndex++] = bucket.get(j);
                }
            }
        }
        return result;
    }
}
