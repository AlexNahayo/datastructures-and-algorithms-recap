package com.nahayo.leetcode.arrays;

public class BestTimeToBuyAndSellStock {

    /**Time (n) & Space (1)**/
    public int maxProfit(int[] prices) {
        // Track the minimum price seen so far
        int buy_price = prices[0];

        // Track the maximum profit found so far
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy_price) {
                // Update minimum price if a lower one is found
                buy_price = prices[i];
            } else {
                // Calculate profit if sold today and update max profit
                int current_profit = prices[i] - buy_price;
                profit = Math.max(current_profit, profit);
            }
        }
        return profit;
    }
}
