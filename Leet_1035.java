class Leet_1035
{
    public int maxUncrossedLines(int[] nums1, int[] nums2) 
    {
        Integer dp[][]=new Integer[nums1.length][nums2.length];
        
        helper(nums1,nums2,0,0,dp);
        return dp[0][0];
        
    }
    
    int helper(int a1[], int a2[], int i, int j, Integer dp[][])
    {
        if(i>=a1.length ||j>=a2.length)
            return 0;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        int c1=a1[i];
        int c2=a2[j];
        
        if(c1==c2)
        {
            return dp[i][j]=1+helper(a1,a2,i+1,j+1,dp);
        }
        else
        {
            return dp[i][j]=Math.max(helper(a1,a2,i,j+1,dp),helper(a1,a2,i+1,j,dp));
        }
    }
}