/*

1. Brute Force
Use 2 loops and track every transaction and maintain a variable maxProfit 
to contain the max value among all transactions.

Time Complexity:- O(n^2)
Space Complexity:- O(1)

*/
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int n = prices.length;

        for(int i=0 ; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                if(prices[j] > prices[i]) {
                    max_profit = Math.max(prices[j]-prices[i], max_profit);
                }
            }
        }

        return max_profit;
    }
}

/*

2. Optimal Solution
Linearly travel the array. 
Maintain a minimum from the starting of the array and compare it with every element of the array, 
if it is greater than the minimum then take the difference and maintain it in max, 
otherwise update the minimum.

Time Complexity:- 
Space Complexity:- 

*/
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = Integer.MAX_VALUE;
        int n = prices.length;

        for (int i=0 ; i<n ; i++) {
            min_price = Math.min(min_price, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_price);
        }

        return max_profit;
    }
}