class Solution {
    public int maxProfit(int[] prices) {
        return solution1_bruteForce(prices);
    }

    public int solution1_bruteForce(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                if ((sell - buy) > profit) profit = sell - buy;
            }
        }
        return profit;
    }
}
