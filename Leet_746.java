// 746. Min Cost Climbing Stairs

// You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

// You can either start from the step with index 0, or the step with index 1.

// Return the minimum cost to reach the top of the floor.

 

// Example 1:

// Input: cost = [10,15,20]
// Output: 15
// Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
// Example 2:

// Input: cost = [1,100,1,1,1,100,1,1,100,1]
// Output: 6
// Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].


class Leet_746 {
    public int minCostClimbingStairs(int[] cost) 
    {
        int n=cost.length;
        Integer dp[]=new Integer[n];
        
        helper(cost,0,n,dp);
        
        return dp[0]>dp[1]?dp[1]:dp[0];
        
    }
    
    int helper(int cost[], int i, int n, Integer dp[])
    {
        if(i>=n)
        {
            return 0;
        }
        
        if(dp[i]!=null)
            return dp[i];
        
        int take1Step=helper(cost,i+1,n,dp);
        int take2Step=helper(cost,i+2,n,dp);
        
        return dp[i]=Math.min(take1Step,take2Step)+cost[i];
    }
}