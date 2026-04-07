class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                int profit = prices[sell] - prices[buy];
                result = Math.max(result, profit);
            } else {
                buy = sell;
            }
            sell++;
        }
        return result;
    }
}
