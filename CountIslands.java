import java.util.*;
import java.io.*;
class CountIslands{   
    public static boolean isValid(int [][]grid, int x,int y)
    {
        int r=grid.length;
        int c=grid[0].length;
        if(x>=r || x<0 || y>=c || y<0 || grid[x][y]==0)
        {
            return false;
        }
        return true;
    }
    public static void callBfs(int [][]grid, int i, int j)
    {
        if(grid[i][j]==1)
        {
            grid[i][j]=0;
        }
        
        int [][]dir={{0,-1},{1,0},{-1,0},{0,1}};
        for(int k=0;k<4;k++)
        {
            int new_x=i+dir[k][0];
            int new_y=j+dir[k][1];
            if(isValid(grid,new_x,new_y))
            {
                callBfs(grid,new_x,new_y);
            }
        }
        
    }
    public static int numIslands(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                    callBfs(grid,i,j);
                }
            }
        }
        return count; 
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][]arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                arr[i][j]=sc.nextInt();
        }
        System.out.println(numIslands(arr));
    }
}
