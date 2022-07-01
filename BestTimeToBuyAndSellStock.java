//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
import java.util.*;
import java.io.*;
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=prices[0],maxProfit=0;
        for(int i=1;i<n;i++)
        {
            if(prices[i]>buy)
            {
                int profit=prices[i]-buy;
                maxProfit=Integer.max(maxProfit,profit);
            }
            else
                buy=prices[i];
        }
        return maxProfit;
        
    }
    //TC:O(N*N) SC:O(1)
    public static void main(String args[])
    {
        SCanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        int maxiProfit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int currProfit=arr[j]-arr[i];
                maxiProfit=Math.max(maxiProfit, currProfit);
            }
        }


        System.out.println(maxiProfit);
    }

    
}
