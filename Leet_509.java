import java.util.Scanner;

public class Leet_509 {
    static public int fib(int n) 
    {
        // int dp[]=new int[n+1]; 
        // helper(n,dp);  //memo call
        // return dp[n];
        
        if(n==0 || n==1)  //space optimized
            return n;
        
        int a=0;
        int b=1;
        int c=0;
        
        for(int i=2;i<=n;i++)
        {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
        
    }
    
    static int helper(int n, int dp[]) //memo
    {
        if(n==1 || n==0)
            return dp[n]=n;
        
        if(dp[n]!=0)
        {
            return dp[n];
        }
        
        int fibnm1=helper(n-1,dp);
        int fibnm2=helper(n-2,dp);
        
        return dp[n]=fibnm1+fibnm2;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int res=fib(n);
        System.out.println(res);
        sc.close();
    }
    
}


