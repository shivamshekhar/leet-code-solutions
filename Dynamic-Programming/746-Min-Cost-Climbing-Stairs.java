class Solution {
    public int[] minCost;
    
    public int minCostClimbingStairs(int[] cost) {
        minCost = new int[cost.length];
        
        for(int i = 0; i < cost.length; i++) {
            if(i == 0 || i == 1) {
                minCost[i] = cost[i];
            } else {
                minCost[i] = Math.min(minCost[i-1] + cost[i], minCost[i-2] + cost[i]);
            }
        }
        
        return Math.min(minCost[cost.length - 1], minCost[cost.length - 2]);
    }
}
