//Coins are infinite and Return the number of combinations that make up that amount.
import java.util.*;
import java.io.*;
public class CoinChangeI {
    //recursion which has optimal substructure property
    //reccurence relation--countWays(arr,coin,sum-arr[coin-1])+countWays(arr,coin-1,sum)
    //TC:O(2^N) SC:O(STACK)
    static int countWays(int arr[], int n, int sum)
    {
        
        // If sum is 0 then there is 1 solution (do not include any coin)
        if (sum == 0)
            return 1;
        
        // If sum is less than 0 then no solution exists
        if (sum < 0)
            return 0;
    
        // If there are no coins and sum is greater than 0, then no solution exist
        if (n<= 0 && sum >= 1)
            return 0;
    
        // count is sum of solutions (i) including arr[m-1] (ii) excluding arr[m-1]
        return countWays(arr, n - 1, sum) +  countWays(arr, n, sum - arr[n - 1]);
    }

    
    //DP Problem TC:O(N*M) SC:O(N)
    public static int countWays2( int S[], int m, int n )
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[]=new int[n+1];
    
        // Base case (If given value is 0)
        table[0] = 1;
    
        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<m; i++)
            for(int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
    
        return table[n];
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
        int ans2=countWays2(arr, n, sum);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
