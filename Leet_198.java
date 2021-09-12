/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/



class Leet_198 {
    public int rob(int[] nums) 
    {
        if(nums.length==1)
            return nums[0];
        
        if(nums.length==2)
            return nums[0]>nums[1]?nums[0]:nums[1];

        int n=nums.length;
        
        Integer dp[]=new Integer[n];
        
        
        helper(nums,0,dp);
        int max=dp[0];
        
        int max2=0;
        
        if(nums.length>1){
            helper(nums,1,dp);
            max2=dp[1];
        }
        
        return max>max2?max:max2;
        
    }
    
    int helper(int a[], int ind, Integer dp[])  //Memoization
    {
        if(ind>=a.length)
            return 0;
        
        if(ind==a.length-1)
            return dp[ind]=a[ind];
        
        if(dp[ind]!=null)
            return dp[ind];
        
        int max=0;
        for(int i=2;i<a.length;i++)  //as we cant rob two adjacent house, so we take a from 2 to further
        {
            int res=a[ind]+helper(a,ind+i,dp);  //and collect the money,
            max=Math.max(res,max);        //then we compare from which step we got the maximum money
        }
        
        return dp[ind]=max;      //we store that maximum money that can be collected starting from the ith house
         
    }

    int solve(int nums[], int n, Integer dp[])   //Tabulation
    {
        dp[n-1]=nums[n-1];
        dp[n-2]=nums[n-2];
        dp[n-3]=nums[n-1]+nums[n-3];  //we maintain a dp array, which stores the maximum money that 
                                      //can be collected starting from the ith house
        for(int i=nums.length-4;i>=0;i--)  //we start from the last 4th house, then we can either jum to the 
        {                                  //2nd last house or the last house, so among those 2 house, whichever house
            dp[i]=nums[i]+Math.max(dp[i+2],dp[i+3]); //has more money we choose to go to that house, and also add mony of the current house, and store the total maximum that we can collect from the current house
        }
        
        return dp[0]>dp[1]?dp[0]:dp[1];
    }
}