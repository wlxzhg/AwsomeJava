package cn.xiaozhigang.ieeextreme.competiton11;
import java.util.*;
import java.lang.*;

public class GottaCatchEmAll {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int [][] arr = new int[r][c];
        for(int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                arr[i][j] = in.nextInt();
            }
        int ans = dfs(arr,0,0,0);
        if(max >= 0)
            System.out.print(1);
        else
            System.out.print(ans * (-1) + 1);
    }
    static int max = Integer.MAX_VALUE;
    static int dfs(int[][] arr,int i,int j,int num) {
        if(i == arr.length - 1 && j == arr.length - 1)
            return num;
        if(j == arr[0].length - 1)
            return dfs(arr,i + 1,j,num + arr[i][j]);
        if(i == arr.length - 1)
            return dfs(arr,i,j + 1,num + arr[i][j]);
        int right = dfs(arr,i,j+1,num+arr[i][j]);
        int down = dfs(arr,i+1,j,num+arr[i][j]);
        return right>down?right:down;
    }
}
