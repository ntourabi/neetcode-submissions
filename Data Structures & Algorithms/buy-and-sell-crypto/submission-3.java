class Solution {
    public int maxProfit(int[] prices) {
        //return solution1_bruteForce(prices);
        return sol_1(prices);
    }

    public int sol_1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if ((prices[j] - prices[i]) > maxProfit) maxProfit = prices[j] - prices[i];
            }
        }
        return maxProfit;
    }


























    public int solution2_slidingWindow(int[] prices) {
        int left = 0; //buy
        int maxProfit = 0;

        for (int right = 0; right < prices.length; right++) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
        }

        return maxProfit;
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
