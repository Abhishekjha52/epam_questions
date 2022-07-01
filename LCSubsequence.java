import java.util.*;
import java.io.*;
public class LCSubsequence {
    public static int LongestCommonSubsequence(int n, int m, String a, String b)
    {
        //recursive approach
        
        //base case
        if(n==0 || m==0)
            return 0;

        if(a.charAt(n-1)==b.charAt(m-1))
            return 1+LongestCommonSubsequence(n-1, m-1, a, b);

        return Math.max(LongestCommonSubsequence(n-1, m, a, b), LongestCommonSubsequence(n, m-1, a, b));
    }

    public static int LongestCommonSubsequence1(int n, int m, String a, String b, int[][] dp)
    {
        //recursive approach + memoisation
        
        //base case
        if(n==0 || m==0)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        if(a.charAt(n-1)==b.charAt(m-1))
            dp[n][m]= 1+LongestCommonSubsequence(n-1, m-1, a, b);

        return dp[n][m]=Math.max(LongestCommonSubsequence(n-1, m, a, b), LongestCommonSubsequence(n, m-1, a, b));
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        //tabulation approach

        if(text1.equals(text2))
            return text1.length();
        int dp[][]= new int [text1.length()+1][text2.length()+1];
        for(int i= 1 ; i<=text1.length(); i++)
        {
            for(int j=1; j<=text2.length(); j++)
            {
                
              if(text1.charAt(i-1) == text2.charAt(j-1))
                 dp[i][j] = 1 + dp[i -1][ j -1] ;
        
                else
                    dp[i][j] = Math.max(dp[i -1][j] , dp[i][j -1]);
            }
            
        }
        
       return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequence3(String text1, String text2) {
        //space optimization

        int[] prev= new int[text2.length()+1];
        int[] cur=new int[text2.length()+1];
        
        for(int j = 0; j <= text2.length(); j++) 
            prev[j]= 0;
        
       
        
        for(int i= 1 ; i<=text1.length(); i++)
        {
            for(int j=1; j<=text2.length(); j++)
            {
                
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    cur[j] = 1 + prev[ j -1] ;
        
                else
                    cur[j] = Math.max( prev[j] , cur[j -1]);
            }
            prev = cur;
        }
        
        return prev[text2.length()];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n=a.length(), m=b.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
                dp[i][j]=-1;
        }
        // int ans=LongestCommonSubsequence(n, m, a, b);
        // int ans1=LongestCommonSubsequence1(n, m, a, b, dp);
        int ans2=longestCommonSubsequence2(a, b);
        int ans3=longestCommonSubsequence3(a, b);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
