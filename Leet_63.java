/*
63. Unique Paths II

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
*/

class Leet_63 
{
    public int uniquePathsWithObstacles(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        
        Integer dp[][]=new Integer[n][m];
        
        helper(grid,0,0,n,m,dp);
        
        return dp[0][0]==null?0:dp[0][0];
        
    }
    
    int helper(int grid[][], int i, int j, int n, int m, Integer dp[][])
    {
        if(i>=n || j>=m || i<0 || j<0 || grid[i][j]==1) //if the robot moves out of the grid or meets an obstacle, 
            return 0;          //then we return 0, means there exist no path further from that cell
        
        if(i==n-1 && j==m-1)   //when we reach our destination cell
            return dp[i][j]=1; //we return 1, indicating that there exist a path to that cell
        
        if(dp[i][j]!=null)    //we have our stored answer of the current cell, which stores the total no. of paths originating from that cell to the destination cell
            return dp[i][j];  //we return the total ways from the current cell to the destination cell
        
        int rmove=helper(grid,i,j+1,n,m,dp);  //we make a move to the right cell
        int dmove=helper(grid,i+1,j,n,m,dp);  //we make a move to the down cell
        
        return dp[i][j]=rmove+dmove;    //whatever answer we get from the two moves, we store that in
    }                                   //our cell, which indicates, that if the robot reaches my cell,
                                        //then he will get the total no of ways of reaching the 
                                        // destination from my cell
    
}