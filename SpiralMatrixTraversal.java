import java.util.*;
import java.io.*;
public class SpiralMatrixTraversal {
    public static void spiralTraverse(int[][] arr, int n)
    {
        int left=0,top=0,right=n-1,bottom=n-1;
        int dir=0;
        while(left<=right && top<=bottom)
        {
            if(dir==0)
            {
                for(int i=left;i<=right;i++)
                    System.out.print(arr[top][i]+" ");
                top++;
            }
            else if(dir==1)
            {
                for(int i=top;i<=bottom;i++)
                    System.out.print(arr[i][right]+" ");
                right--;
            }
            else if(dir==2)
            {
                for(int i=right;i>=left;i--)
                    System.out.print(arr[bottom][i]+" ");
                bottom--;
            }
            else if(dir==4)
            {
                for(int i=bottom;i>=top;i--)
                    System.out.print(arr[i][left]+" ");
                left++;
            }
            dir=(dir+1)%4;
        }

    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                arr[i][j]=sc.nextInt();
        }
        spiralTraverse(arr,n);
    }
}
