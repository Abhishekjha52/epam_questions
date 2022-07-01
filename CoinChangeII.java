//Coins are infinite and Return the fewest no of coins that make up that amount.
import java.util.*;
import java.io.*;
public class CoinChangeII {
    public int coinChange(int[] coins, int n, int amount) {
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<amount+1;j++)
            {
                if(i==0)
                    dp[0][j]=Integer.MAX_VALUE-1;
                if(j==0)
                    dp[i][0]=0;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(coins[i-1]<=j)
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        if(dp[n][amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[n][amount];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of coins array");
        int n=sc.nextInt();
        System.out.println("Ener coins array elements");
        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the target sum");
        int sum=sc.nextInt();
        int ans=countWays(arr, n, sum);
        System.out.println(ans);

    }
}
