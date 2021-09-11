// Climbing Stairs
// Easy

// 8013

// 237

// Add to List

// Share
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step


class Leet_70 
{
    public int climbStairs(int n) 
    {
        Integer dp[]=new Integer[n+1];
        
        helper(n,0,dp);
        return dp[0];
    }
    
    int helper(int n, int i, Integer dp[])
    {
        if(i>n)
            return 0;
        
        if(i==n)
            return dp[i]=1;
        
        if(dp[i]!=null)
            return dp[i];
        
        int take1Step=helper(n,i+1,dp);
        int take2Step=helper(n,i+2,dp);
        
        return dp[i]=take1Step+take2Step;
    }
}


