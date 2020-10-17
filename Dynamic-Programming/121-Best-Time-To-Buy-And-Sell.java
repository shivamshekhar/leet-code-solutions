class Solution {
    public int[][] profit;
    
    public int maxProfit(int[] prices) {
        /*
        
        // Naive Brute Force approach
        // Time Complexity = O(N^2)
        
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                if(prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }            
            }
        }
        
        return maxProfit;
        
        */
        
        /******************************************************************/
        
        /*
        //Optimized approach
        //Time Complexity = O(N)
        */
        
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}
