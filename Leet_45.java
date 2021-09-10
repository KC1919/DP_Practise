//jump game II

// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// You can assume that you can always reach the last index.

 

// Example 1:

// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

class Leet_45 {
    public int jump(int[] nums) 
    {
        Integer dp[]=new Integer[nums.length];
        helper(nums,0,dp);
        return dp[0]-1;
    }
    
    int helper(int a[], int n, Integer dp[]) 
    {
        if (n == a.length - 1) 
        {
            return dp[n]=1;
        }

        if (dp[n] != null)
            return dp[n];

        int min=Integer.MAX_VALUE;
        for (int i = a[n]; i >= 1; i--) 
        {
            if (i + n < a.length) 
            {
                int res=helper(a,n+i,dp);
                min=Math.min(res,min);
            }
        }
        return dp[n]=(min!=Integer.MAX_VALUE)?min+1:Integer.MAX_VALUE;
    }
}