class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) return maxHeap.poll();

            int largest = maxHeap.poll();
            int secondLargest = maxHeap.poll();
            int diff = largest - secondLargest;

            if (diff > 0) maxHeap.offer(diff);
        }

        return 0;
    }
}
