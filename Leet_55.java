public class Leet_55 {
    public boolean canJump(int[] nums) {

        Integer dp[] = new Integer[nums.length];
        helper(nums, 0, dp);
        return dp[0] == 1 ? true : false;
    }

    boolean helper(int a[], int n, Integer dp[]) {
        if (n == a.length - 1) {
            dp[n] = 1;
            return true;
        }

        if (dp[n] != null)
            return dp[n] == 1 ? true : false;

        for (int i = a[n]; i >= 1; i--) {
            if (i + n < a.length) {
                if (helper(a, i + n, dp)) {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        dp[n] = 0;
        return false;
    }
}


//Optimized

class Solution {
    public boolean canJump(int[] nums) {
        int goal=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=goal){
                goal=i;
            }
        }
        
        return goal==0 ? true : false;
    }
}
